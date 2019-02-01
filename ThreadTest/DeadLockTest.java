package ThreadTest;
public class DeadLockTest{

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.setUserName("A");
        DeadLock1 deadLock1 = new DeadLock1(deadLock);
        deadLock1.start();
        try
        {
            Thread.sleep(10);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        deadLock.setUserName("B");
        DeadLock2 deadLock2 = new DeadLock2(deadLock);
        deadLock2.start();
    }
}

class DeadLock1 extends  Thread
{
    private DeadLock deadLock;
    public DeadLock1(DeadLock deadLock)
    {
        this.deadLock = deadLock;
    }
    @Override
    public void run()
    {
        deadLock.getUserName();
    }
}

class DeadLock2 extends Thread
{
    private DeadLock deadLock;
    public DeadLock2(DeadLock   deadLock)
    {
        this.deadLock = deadLock;
    }
    @Override
    public void run()
    {
        deadLock.getUserName();
    }
}