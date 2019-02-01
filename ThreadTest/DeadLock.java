package ThreadTest;


public class DeadLock {
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private String userName;
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public void getUserName()
    {
        if(userName.equals("A"))
        {
            synchronized (lock1)
            {
                System.out.println("current thread " + Thread.currentThread().getName() + " userName:" + this.userName);
                try
                {
                    Thread.sleep(2000);
                    synchronized (lock2)
                    {
                        System.out.println("lock1->lock2");
                    }
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }else {

            synchronized (lock2)
            {
                System.out.println("current thread " + Thread.currentThread().getName() + " userName:" + this.userName);
                try
                {
                    Thread.sleep(2000);
                    synchronized (lock1)
                    {
                        System.out.println("lock2->lock1");
                    }
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

}
