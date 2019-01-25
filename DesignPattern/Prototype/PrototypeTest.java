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
