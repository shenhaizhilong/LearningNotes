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
