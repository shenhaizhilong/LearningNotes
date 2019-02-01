package hello_world;

import java.util.ArrayList;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
public class ErasedTypeEquivalence
{
    public static void main(String[] args)
    {
        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1 ==c2);
    }
}
