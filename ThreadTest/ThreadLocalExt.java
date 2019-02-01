package ThreadTest;

import java.util.Date;

public class ThreadLocalExt extends ThreadLocal {
    @Override
    public Object initialValue()
    {
        return new Date().getTime();
    }

    public static void main(String[] args) {
        try
        {
            for (int i = 0; i < 10; i++) {
                System.out.println("In main thread=" + Tools.threadLocalExt.get());
                Thread.sleep(100);
            }

            Thread.sleep(500);
            ThreadA threadA = new ThreadA();
            threadA.start();

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

class Tools
{
    public static ThreadLocalExt threadLocalExt = new ThreadLocalExt();
}

class ThreadA extends Thread
{
    @Override
    public void run()
    {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("In ThreadA value = " + Tools.threadLocalExt.get());
                Thread.sleep(100);
            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

