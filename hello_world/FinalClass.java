package hello_world;

import java.util.LinkedList;
import java.util.List;

public final class FinalClass
{
    public static final int[] a ={1,2,3};
    public static final List<String> b = new LinkedList<>();
    public static void main(String[] args) {
        a[0] = 100;
        System.out.println(a[0]);
        for (int i = 0; i < 100; i++) {
            b.add(Integer.toString(i));

        }
        System.out.println(b);
        System.out.println(b.getClass());
    }
}

//class is final, who can't be extends
//class FinalClass2 extends FinalClass
//{
//    //overridden method is final
////    void Test()
////    {
////        System.out.println("Final method1");
////    }
//}

class FinalClassMethod
{
    final void Test()
    {
        System.out.printf("final method");
    }
}

class FinalClassMethod2 extends FinalClassMethod
{
    // method is final, overridden is forbidden
//    void Test()
//    {
//        System.out.println("sub class final method test");
//    }
}

