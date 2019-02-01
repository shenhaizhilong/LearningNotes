package hello_world;

import java.io.InputStreamReader;

/**
 * Created by shenhaizhilong on 6/30/2017.
 */
public class BItOperation
{
    public static void main(String[] args)
    {
        final int x = 100000000;
        int n=2;
        // set nth bit
        // x | (1<<n)
        Runnable runnable1 = ()-> System.out.println( x| (1<<2));
        runnable1.run();

        int y = x | (1<<n);
        System.out.println( y&~(1<<n));
        //max value of Integer

        System.out.println("Max value of Integer");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(~(1<<31));
        System.out.println((1<<31) -1);
        System.out.println((1<<-1) -1);
        //min value of Integer
        System.out.println("Min value of integer");
        System.out.println(Integer.MIN_VALUE);
        System.out.println((1<<31));
        System.out.println((1<<-1));
        System.out.println((1<<-30));

        //max value of the long
        System.out.println("max value of the long");
        System.out.println(Long.MAX_VALUE);
        System.out.println(((long)1<<63)-1);
        System.out.println(((long)1<<128));

        //min value of the long
        System.out.println("Min value of the long");
        System.out.println(Long.MIN_VALUE);
        System.out.println(((long)1 <<-1));
        System.out.println(((long)1<<63));

        //
        //Multiply by the mth power of 2
        System.out.println(10<<5);
        //Divide by the mth power of 2
        System.out.println(101>>2);

        //check equality
        System.out.println((100^100) ==0);
        System.out.println(!((100^100) ==0));

        //check if the  number is odd
        System.out.println("(i&1) ==1");
        for(int i=1; i<9; i++)
        {
            System.out.println((i&1) ==1);
        }

        int xx =Integer.MIN_VALUE;
        System.out.println(xx>>31);
        System.out.println(Integer.MAX_VALUE>>31);
        int z = Integer.MIN_VALUE;
        System.out.println((z^(z>>31)) - (z>>31));
        // swap two values
       //     swap();

        System.out.println("oxffffffff");
        System.out.println(0xffffffff);
        System.out.println();


        //get the absolute value
        System.out.println(abs(-10000));

        //check whether both number have the same sign
        System.out.println(isSameSign(1,-1));

        //flip the sign
        System.out.println(Integer.MAX_VALUE);
        System.out.println(flipSign(Integer.MAX_VALUE));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(flipSign(Integer.MIN_VALUE));

    }

    public static void swap()
    {

        int a=100;
        int b = 200;
        System.out.println(a);
        System.out.println(b);
        a^=b;
        b^=a;
        a^=b;
        System.out.println("after swap");
        System.out.println(a);
        System.out.println(b);
    }

    public static int abs(int a)
    {
        return  ((a^(a>>31)) -(a>>31));
    }
    public static boolean isSameSign(int a, int  b)
    {
        return (a^b)>=0;
    }
    public static int flipSign(int a)
    {
        return ~a +1;
    }
}
