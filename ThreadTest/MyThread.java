package ThreadTest;


public class MyThread implements Runnable
{
    Thread thread;
    public MyThread(String name)
    {
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " Starting");
        try
        {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(400);
                System.out.println("In" + thread.getName() + ", count is" + i);
            }
        }catch (InterruptedException e)
        {
            System.out.println(thread.getName() + " interrupted");
        }
        System.out.println(thread.getName() + " terminating");


    }

    public static void main(String[] args) {
        System.out.println("Main Thread starting");
        MyThread mt1 = new MyThread("China #1");
        MyThread mt2 = new MyThread("China #2");
        MyThread mt3 = new MyThread("China #3");

//        for (int i = 0; i < 50; i++) {
//            System.out.print(".");
//            try
//            {
//                Thread.sleep(100);
//            }catch (InterruptedException e)
//            {
//                System.out.println("main thread Interrupted");
//            }
//        }
        while (mt1.thread.isAlive() || mt2.thread.isAlive() || mt3.thread.isAlive())
        {
            try
            {
                Thread.sleep(100);
            }catch (InterruptedException e)
            {
                System.out.println("Interrupted");
            }

        }
        System.out.println("Main Thread ending");
    }
}
