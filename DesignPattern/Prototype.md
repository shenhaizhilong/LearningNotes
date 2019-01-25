# 原型模式 Prototype
> 顾名思义，以某一个对象作为原型，对其进行复制、克隆、拷贝，产生一个和原对象类似的新对象。 复制对象是通过实现clonable 接口的clone() 方法的。
> 派生类的clone() 方法中，调用super.clone()
> clone() 返回Object 对象
> **浅拷贝**：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
> **深拷贝**：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深拷贝进行了完全彻底的复制，而浅拷贝不彻底。

**clone() 方法满足**:

*  1. 对任何对象x，都有x.clone() != x，即克隆对象与原对象不是同一个对象
*  2. 对任何对象x, 都有x.clone().getClass() == x.getClass(), 即克隆对象与原型对象的类型一样
*  3. x.clone().equals(x) == true

```java
package DesignPattern.Prototype;

import java.io.*;

public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 2147483647l;
    private String name;
    private SerializableObject obj;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

    public SerializableObject getObj() {
        return obj;
    }


    // 浅拷贝,如果没定义clone() 方法而调用了该方法，会抛出cloneNotSupportedException 
    public Object clone() throws CloneNotSupportedException
    {
        Prototype prototype = (Prototype)super.clone();
        return prototype;
    }

    // 深拷贝
    public Object deepClone() throws  ClassNotFoundException,  IOException
    {

		// The ByteArrayOutputStream class stream creates a buffer in memory and all the data sent to the stream is stored in the buffer.

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream  = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();

    }


    class SerializableObject implements Serializable
    {
        private static final long serialVersionUID = 2147483647;
    }
}


```

## Test
___
```java
package DesignPattern.Prototype;

import java.io.IOException;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/26 0:27
 */
public class PrototypeTest {

    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        prototype.setName("demo1");
        prototype.add(10);
        try
        {
            Prototype prototype2 = (Prototype)prototype.clone();
            System.out.println(prototype.hashCode());
            System.out.println(prototype2.hashCode());
            System.out.println(prototype == prototype2);
            // change prototype
            prototype.setName("changed prototype");
            prototype.add(100);
            System.out.println("prototype name: " + prototype.getName());
            System.out.println("prototype2 name:" + prototype2.getName());
            System.out.println("prototype 1 list");
            prototype.printList();
            System.out.println("prototype 2 list");
            prototype2.printList();
        }catch (CloneNotSupportedException ex)
        {
            ex.printStackTrace();
        }

        System.out.println("*****************");
        try
        {
            Prototype prototype3 = (Prototype)prototype.deepClone();
            System.out.println(prototype.hashCode());
            System.out.println(prototype3.hashCode());
            prototype.add(1000);
            System.out.println("prototype 1 list");
            prototype.printList();
            System.out.println("prototype 3 list");
            prototype3.printList();
        }catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }


    }
}

```
## Output:
___

	2133927002
	1836019240
	false
	prototype name: changed prototype
	prototype2 name:demo1
	prototype 1 list
	[10, 100]
	prototype 2 list
	[10, 100]
	*****************
	2133927002
	1854731462
	prototype 1 list
	[10, 100, 1000]
	prototype 3 list
	10,100

