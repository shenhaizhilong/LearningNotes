package hello_world;

/**
 * Created by shenhaizhilong on 5/1/2017.
 */
public class BasicThreads
{
    public static void main(String[] args)
    {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff:");
    }
}
