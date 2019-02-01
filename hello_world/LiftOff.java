package hello_world;

/**
 * Created by shenhaizhilong on 5/1/2017.
 */
public class LiftOff implements Runnable
{
    protected int countDown = 10; //default
    private static int taskCount =0;
    private int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){this.countDown = countDown;}
    public String status()
    {
        return "#" + id + "(" + (countDown>0?countDown:"Liftoff!") + "),";
    }
    public void run()
    {
        while (countDown-->0)
        {
            System.out.print(status());
            Thread.yield();
            System.out.println("Thread id:" + Thread.currentThread().getId());
        }
    }
}
