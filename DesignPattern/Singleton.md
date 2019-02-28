# Design Pattern
___
## 一 单例模式

* 私有构造器来限制在类外部实例化
* 该类私有的静态变量是该类的唯一实例
* 静态方法返回该类的唯一实例，外部世界想要获取该单实例，只能通过这个全集进入点

### 1.饿汉模式|着急模式 --> 立即加载，等不及了，所以称为饿汉模式;  **非线程安全**getSingleton 没有使用同步方法，无法提供异常处理
```java
    package DesignPattern.Singleton;
    
    import java.util.Random;
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    
    /**
     * @author: shenhaizhilong
     * @date: 2019/1/24 19:39
     *
     * 非线程安全
     * 饿汉模式|着急模式 --> 立即加载，等不及了，所以称为饿汉模式
     *
     * 类被加载，静态实例变量立即被创建，但getSingleton 方法并没有同步，所以有可能会出现非线程安全问题
     * 
     */
    
    // final class
    public final class HungrySingleton {
        // just create a single instance
        private static final HungrySingleton singleton = new HungrySingleton();
    
        // private constructor， forbidden to  call construction out side of this class
        private HungrySingleton()
        {
            // 禁止通过反射实例化
            if(singleton != null)
            {
                throw new IllegalStateException("Already initialized");
            }
        }
    
        public static HungrySingleton getSingleton()
        {
            try {
                Random random = new Random();
                int sec = random.nextInt(3)*1000;
                Thread.sleep(sec);
            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
            return singleton;
        }
    
        public static void main(String[] args) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    HungrySingleton singleton = HungrySingleton.getSingleton();
                    System.out.println(singleton.hashCode());
                }
            };
    
            ExecutorService service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 20; i++) {
                service.submit(task);
            }
            service.shutdown();
        }
    
    }

```

### 2. 懒汉模式
```java
    package DesignPattern.Singleton;
    
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    
    /**
     * @author: shenhaizhilong
     * @date: 2019/1/24 19:54
     *
     *
     * 懒汉单例模式 --> 延迟加载; 兄弟别急咱等会儿再加载
     * 第一次调用getSingleton 的时候，该单例被创建
     */
    public final class LazySingleton {
        private static  LazySingleton singleton;
    
        // private constructor， forbidden to  call construction out side of this class
        private LazySingleton()
        {
            // 禁止通过反射实例化
            if(singleton != null)
            {
                throw new IllegalStateException("Already initialized");
            }
        }
    
        // 线程安全但是效率很低，下一个线程想要取得对象必须要等上一个线程执行完毕
        public synchronized static LazySingleton getSingleton()
        {
    
            if(singleton == null)
            {
                singleton = new LazySingleton();
            }
    
            return singleton;
        }
    
    
        //非线程安全
        public  static LazySingleton getSingleton2()
        {
                if(singleton == null)
                {
                    // 只对关键代码进行同步，减小锁持有时间和范围,提高效率
                    synchronized(LazySingleton.class) {
                        singleton = new LazySingleton();
                    }
                }
    
            return singleton;
        }
    
        public static void main(String[] args) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    LazySingleton singleton = LazySingleton.getSingleton2();
                    System.out.println(singleton.hashCode());
                }
            };
    
            ExecutorService service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 20; i++) {
                service.submit(task);
            }
            service.shutdown();
        }
    }

```


### 3.静态内部类单例模式 
```java
	package DesignPattern.Singleton;
    import java.io.ObjectStreamException;
    import java.io.Serializable;
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    
    /**
     * @author: shenhaizhilong
     * @date: 2019/1/24 20:32
     *
     * 当 StaticInnerClassSingleton 类加载时，静态内部类 SingletonHandler 没有被加载进内存。只有当调用 getSingleton() 方法从而触发
     * SingletonHandler.singleton 时 SingletonHandler 才会被加载，此时初始化 singleton 实例，并且 JVM 能确保 singleton 只被实例化一次。
     *
     * 这种方式不仅具有延迟初始化的好处，而且由 JVM 提供了对线程安全的支持。
     * 静态内部类实现单例模式
     * 不足： 反序列化时仍可以得到多例 所以需要readResolve() method
     */
    public final class StaticInnerClassSingleton implements Serializable {
    
        private static class SingletonHandler
        {
            private static StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
        }
    
        private StaticInnerClassSingleton()
        {
    
        }
    
        public static StaticInnerClassSingleton getSingleton()
        {
            return SingletonHandler.singleton;
        }
    
    
        protected Object readResolve() throws ObjectStreamException
        {
            return SingletonHandler.singleton;
        }
    
    
        public static void main(String[] args) {
            StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getSingleton();
            StaticInnerClassSingleton singleton1 = StaticInnerClassSingleton.getSingleton();
            System.out.println(singleton.hashCode() == singleton1.hashCode());
    
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    StaticInnerClassSingleton singleton2 = StaticInnerClassSingleton.getSingleton();
                    System.out.println(singleton2.hashCode());
                }
            };
    
            ExecutorService service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 20; i++) {
                service.submit(task);
            }
            service.shutdown();
        }
    }
```

### 4. 静态代码块 单例模式
```java
    package DesignPattern.Singleton;    
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    
    /**
     * @author: shenhaizhilong
     * @date: 2019/1/24 20:44
     *
     * 静态代码块在使用类的时候已经执行过了，所以可以用静态代码块的特性来实现
     *
     */
    public final class StaticCodeBlockSingleton {
    
        private static volatile StaticCodeBlockSingleton singleton;
        private StaticCodeBlockSingleton()
        {
            // 禁止通过反射实例化
            if(singleton != null)
            {
                throw new IllegalStateException("Already initialized");
            }
        }
    
        // static code block
        static {
            singleton = new StaticCodeBlockSingleton();
        }
    
        public static StaticCodeBlockSingleton getSingleton()
        {
            return singleton;
        }
    
    
        public static void main(String[] args) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    StaticCodeBlockSingleton singleton = StaticCodeBlockSingleton.getSingleton();
                    System.out.println(singleton.hashCode());
                }
            };
    
            ExecutorService service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 20; i++) {
                service.submit(task);
            }
            service.shutdown();
        }
    
    }

```

### 5. 枚举单例
在使用枚举类时，构造方法会自动被调用
Joshua Bloch, Effective Java 2nd Edition p.18

A single-element enum type is the best way to implement a singleton

```java
    package DesignPattern.Singleton;
    
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    
    /**
     * @author: shenhaizhilong
     * @date: 2019/1/24 20:48
     *
     * 在使用枚举类时，构造方法会自动被调用
     */
    public  enum    EnumSingleton {
         SINGLETON;
        public static void main(String[] args) {
    
             EnumSingleton singleton = EnumSingleton.SINGLETON;
             EnumSingleton singleton1 = EnumSingleton.SINGLETON;
            System.out.println(singleton.hashCode() == singleton1.hashCode());
    
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    EnumSingleton singleton3 = EnumSingleton.SINGLETON;
                    System.out.println(singleton3.hashCode());
                }
            };
    
            ExecutorService service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 20; i++) {
                service.submit(task);
            }
            service.shutdown();
        }
    }


```

### 6. Double check locking --**推荐**
```java
   package DesignPattern.Singleton;
   import java.util.concurrent.ExecutorService;
   import java.util.concurrent.Executors;
   
   /**
    * thread  safe singleton class
    * @author: shenhaizhilong
    * @date: 2019/1/14 14:14
    *
    *推荐使用，线程安全
    * double check locking
    *
    */
   public final class SingletonDoubleCheckLocking {
       //  volatile 确保可见性与有序性
       private static volatile SingletonDoubleCheckLocking ourInstance;
       // 禁止类外部调用构造函数
       private SingletonDoubleCheckLocking() {
           // 禁止通过反射实例化
           if(ourInstance != null)
           {
               throw new IllegalStateException("Already initialized");
           }
       }
   
       // double check locking  technology
       public static SingletonDoubleCheckLocking getInstance() {
           if(ourInstance ==  null)
           {
               // 只对关键代码进行同步，减小锁持有时间和范围,提高效率
               synchronized (SingletonDoubleCheckLocking.class)
               {
                   if(ourInstance == null)
                   {
                       ourInstance = new SingletonDoubleCheckLocking();
                   }
               }
           }
   
           return ourInstance;
       }
   
   
       public static void main(String[] args) {
           Runnable task = new Runnable() {
               @Override
               public void run() {
                   SingletonDoubleCheckLocking singleton = SingletonDoubleCheckLocking.getInstance();
                   System.out.println(singleton.hashCode());
               }
           };
   
           ExecutorService service = Executors.newFixedThreadPool(20);
           for (int i = 0; i < 20; i++) {
               service.submit(task);
           }
           service.shutdown();
       }
   }
```

### 7. Serialize issue

```java
package DesignPattern.Singleton;

import java.io.*;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/25 1:35
 */
public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = 3973835013585169467L;
    private SerializedSingleton(){}
    private static class SingletonHelper
    {
        private static final SerializedSingleton singleton = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance()
    {
        return SingletonHelper.singleton;
    }

    protected Object readResolve()
    {
        return getInstance();
    }

    public static void main(String[] args) throws FileNotFoundException,IOException,ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.txt"));
        out.writeObject(instanceOne);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.txt"));
        SerializedSingleton instanceTwo = (SerializedSingleton)in.readObject();
        in.close();
        System.out.println("one " + instanceOne.hashCode());
        System.out.println("two " + instanceTwo.hashCode());
        // my results, So it destroys the singleton pattern, to overcome this scenario all
        // we need to do it provide the implementation of readResolve() method.
        // one 621009875
        // two 381259350

        // after we provide the readResolve method, hashcode is the same one
        // one 621009875
        // two 621009875
    }
}

```

### 8、 CAS  Singleton

可以使用CAS  操作来实现Singleton

```java

package DesignPattern.Singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/28 17:35
 */
public final class CASSingleton {

    private static   volatile AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();

    private CASSingleton()
    {
        // 禁止通过反射实例化
        if(INSTANCE.get() != null)
        {
            throw new IllegalStateException("Already initialized");
        }
    }

    public static CASSingleton getInstance()
    {
        for(;;)
        {
            CASSingleton curr = INSTANCE.get();
            if(curr != null)return curr;
            curr = new CASSingleton();
            if(INSTANCE.compareAndSet(null, curr))
            {
                return curr;
            }
        }
    }




    public static void main(String[] args) {


        CountDownLatch countDownLatch = new CountDownLatch(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                try
                {
                    System.out.println("Count:" + countDownLatch.getCount());
                    countDownLatch.await();
                    CASSingleton   casSingleton = CASSingleton.getInstance();
                    System.out.println("HashCode:" + casSingleton.hashCode());
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }
        };
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(runnable);
        }

        service.shutdown();
    }
}

```

```html

Count:9
Count:8
Count:7
Count:6
Count:5
Count:4
Count:3
Count:2
Count:1
Count:0
HashCode:331310282
HashCode:331310282
HashCode:331310282
HashCode:331310282
HashCode:331310282
HashCode:331310282
HashCode:331310282
HashCode:331310282
HashCode:331310282
HashCode:331310282
```