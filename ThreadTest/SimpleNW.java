package ThreadTest;


public class SimpleNW
{
    final static Object object = new Object();
    public static class T1 extends Thread
    {
        @Override
        public void run()
        {
            synchronized (object)
            {
                System.out.println(System.currentTimeMillis() + ": T1 Started");
                try
                {
                    System.out.println(System.currentTimeMillis() + ": T1 wait for object");
                    object.wait();
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": T1 ended");
            }
        }
    }

    public static final class T2 extends Thread
    {
        @Override
        public void run()
        {
            synchronized (object)
            {
                System.out.println(System.currentTimeMillis() + ": T2 Started");
                System.out.println(System.currentTimeMillis() + ": T2 Notify");
                object.notify();

                System.out.println(System.currentTimeMillis() + ": T2 ended");
                try
                {
                    Thread.sleep(2000);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.start();
        T2 t2= new T2();
        t2.start();

    }
}
