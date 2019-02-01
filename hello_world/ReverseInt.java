package hello_world;

/**
 * Created by shenhaizhilong on 5/27/2017.
 */
public class ReverseInt
{
    public static int reverseInt(int num)
    {
        int results=0;
        while (num !=0)
        {
            int tail = num %10;
            int newNum = results*10 + tail;

            // if newNum overflow then (newNum -tail)/10 != results
            if ((newNum -tail)/10 != results)
            {
                return 0;
            }
            results = newNum;
            num = num/10;

        }
        return results;
    }

    public static void main(String[] args)
    {
        int[] a = {0, 100, 1000, 102, 123, -124, 200009, 2000000009};
        for (int i :
                a) {
            System.out.println(reverseInt(i));

        }
    }
}
