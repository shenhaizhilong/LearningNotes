package javavm;

import java.util.List;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/24 10:47
 */
public class GenericTypes {
    //can't compile.

//    public static int method(List<String> list)
//    {
//        System.out.println("list<String> method");
//        return 0;
//    }

    public static String method(List<Integer> list)
    {
        System.out.println("List<Integer> method");
        return "";
    }
}
