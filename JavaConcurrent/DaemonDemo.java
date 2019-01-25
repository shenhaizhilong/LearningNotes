package JavaConcurrent;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 14:33
 */
public class DaemonDemo {

    private static class DaemonTask implements Runnable
    {
        @Override
        public void run() {

            try
            {
                while (true)
                {
                    System.out.println("I am the Daemon thread, haha");
                    Thread.sleep(100);

                }
            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }


        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonTask());
        thread.setDaemon(true);
        thread.start();
        System.out.println("Main thread");
        Thread.sleep(1000);
    }
}
