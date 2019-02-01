package ThreadTest;

public class DeadLockTest2 {
    private Object lockA = new Object();
    private Object lockB = new Object();

    public void Test()
    {
        synchronized (lockA)
        {
            System.out.println("LockA -> LockB" + Thread.currentThread().getName());
            try
            {
                Thread.sleep(300);
                synchronized (lockB)
                {
                    System.out.println("lockA->LockB");
                }
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
    public void Test2()
    {
        synchronized (lockB)
        {
            System.out.println("LockB->LockA " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                synchronized (lockA)
                {
                    System.out.println("LockB->LockA");
                }
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        DeadLockTest2 deadLockTest2 = new DeadLockTest2();
        Thread threadA = new Thread(()-> deadLockTest2.Test());
        Thread threadB = new Thread(()-> deadLockTest2.Test2());
        threadA.start();
        threadB.start();
    }
}


