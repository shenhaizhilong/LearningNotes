package JavaConcurrent;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/13 12:30
 */
public class VolatileDemo {
    private static volatile boolean close = false;

    private static class UserA implements Runnable
    {
        @Override
        public void run() {
            try {
                while (!close)
                {
                    System.out.println("Running UserA");
                    Thread.sleep(1000*1);
                }
            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }

            System.out.println("closing UserA");

        }
    }

    private static class UserB implements Runnable
    {
        @Override
        public void run() {
            try
            {
                System.out.println("Running UserB");
                Thread.sleep(1000*5);
            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
            close = true;
            System.out.println("closing UserB");
        }
    }

    public static void main(String[] args) {
        new Thread(new UserA()).start();
        new Thread(new UserB()).start();
    }
}
