package hello_world;

import java.util.Date;
import java.util.Random;

public class test_date
{
    public static void main(String[] args)
    {
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println("current time is :" + date.getTime() + "ms");
        Random rd1 = new Random(10);
    /*	for( int i = 0; i < 10; i++)
		{
			System.out.println( rd1.nextInt(100));
			
		}
		*/
        for (int i = 0; i < 10; i++) {
            int a = rand_int(10, 100);
            System.out.println(a);

        }

    }

    public static int rand_int(int a, int b)
    {
        return (int) (Math.random() * (b - a) + a);
    }


}
