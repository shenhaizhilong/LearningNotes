package ThreadTest;


public class Novisibility
{
    private static volatile boolean ready;
    private static int number;

    public static class ReaderThread extends Thread
    {
        @Override
        public void run()
        {
            while (!ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(100);
        number = 47;
        ready = true;
        Thread.sleep(10);
    }
}
