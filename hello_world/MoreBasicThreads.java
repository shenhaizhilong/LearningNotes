package hello_world;

/**
 * Created by shenhaizhilong on 5/1/2017.
 */
public class MoreBasicThreads
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
