package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/1 12:04
 */
public class TestStack {

    public static void main(String[] args) {
        TestStack t1 = new TestStack();
        TestStack t2 = new TestStack();
        System.out.println(t1);
        System.out.println(t2);
       // System.out.println(t1 = t2);
        System.out.println(t1 == (t1 = t2));
        System.out.println(t1);
//        System.out.println( (t1 = t2) == t1);
//        System.out.println(t1);
    }
}
