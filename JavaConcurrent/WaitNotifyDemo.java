package JavaConcurrent;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 13:48
 */
public class WaitNotifyDemo {
    private static Object object = new Object();
    public static class Wait extends Thread
    {
        @Override
        public void run() {
            synchronized (object)
            {

                try
                {
                    System.out.println("Started Waiting: " +  System.currentTimeMillis());
                    object.wait();
                    Thread.sleep(1000);
                    System.out.println("After waiting:" + System.currentTimeMillis());
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }
        }
    }

    public static class Notify extends Thread
    {
        @Override
        public void run() {
            synchronized (object)
            {
                System.out.println("Started Notify:" + System.currentTimeMillis());
                object.notify();
                System.out.println("After Notify:" + System.currentTimeMillis());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Wait().start();
        Thread.sleep(1000);
        new Notify().start();
    }
}
