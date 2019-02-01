package ThreadTest;


public class BadSuspend {
    public static Object object = new Object();
    public static class T extends Thread
    {
        public T(String name)
        {
            super(name);
        }
        @Override
        public void run()
        {
            synchronized (object)
            {
                System.out.println(this.getName() + " started");
                Thread.currentThread().suspend();
                System.out.println(this.getName() + " continue");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T("T1");
        T t2 = new T("T2");
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();
    }
}
