package TheArtOfCoding;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/19 18:09
 *
 * // not work for java
 */
public class MakeUsage {

    public static void usage()
    {
        for(;;)
        {
            for (int i = 0; i < 9600000; i++);
            try
            {
                Thread.sleep(10);
            }catch (InterruptedException ex)
            {

            }

        }
    }
    public static void main(String[] args) {

    }
}
