package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/22 9:20
 */
public class B extends A{
    private int age;

    public B(String name, int age)
    {
        super(name);
        this.age = age;

    }

    public static void main(String[] args) {
        /*  ddd
        */

        B b = new B("Tom", 10);
        System.out.println(b);
        String a = "aaa";
        String c = new String("aaa");
        System.out.println(a == c);

    }



}
