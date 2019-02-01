package hello_world;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.*;
/**
 * Created by shenhaizhilong on 6/11/2017.
 */
public class Base62
{
    // base 64 alphabet
    // https://tools.ietf.org/html/rfc4648#section-4
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9', 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z',
            'A' , 'B' , 'C' , 'D' , 'E' , 'F' ,
            'G' , 'H' , 'I' , 'J' , 'K' , 'L' ,
            'M' , 'N' , 'O' , 'P' , 'Q' , 'R' ,
            'S' , 'T' , 'U' , 'V' , 'W' , 'X' ,
            'Y' , 'Z'

    };
    public static void main(String[] args)
    {
//
//        int mask = 0x01;
//        int n;
//        for (int i = 0; i <= 100; i++)
//        {
//            n = i & mask;
//            System.out.println(n);
//        }

        long l = 1;
        long c = l <<61;
        // c = 2305843009213694082l;
        System.out.println(c);
        String a ="";
        long b;
        for(long  i=c; i <=c; i++)
        {
            a = Base10ToBase62(i);

            b = Base62ToBase10(a);
            System.out.println(b);
            System.out.println(a);
        }


    }

    public static String Base10ToBase62(long number)
    {
        if (number < 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        long mask = 62;
        long remainer;
        do {
            remainer = number % mask;
            //System.out.println(remainer);
            result.append(digits[(int) remainer]);
            number = number / mask;
            //System.out.println("number:" + number);
        } while (number > mask - 1);
        if (number != 0)
        {
            result.append(digits[(int)number]);
        }

        result.reverse();
        return result.toString();
    }

    public static long Base62ToBase10(String str)
    {
        long base = 62;
        long num = 0;
        int index = 0;
        String charArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0; i< str.length(); i++)
        {

            index = charArray.indexOf(str.charAt(i));
            if (index <0)
            {
                throw new IllegalArgumentException("Illegal argument");
            }
            num += (long)(index * (Math.pow(base, str.length() -i -1)));

        }
        return num;
    }


}
