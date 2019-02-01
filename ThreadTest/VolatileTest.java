package ThreadTest;


public class VolatileTest
{
    public static volatile int i=0;
    public static class PlusTask implements Runnable
    {
        @Override
        public void run()
        {
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int j = 0; j < threads.length; j++) {
            threads[j] = new Thread(new PlusTask());
            threads[j].start();
        }
        for (int j = 0; j < threads.length; j++) {
            threads[j].join();
        }

        System.out.println("Final I is: " + i);
        //while (true);
        //System.out.println("hahh");
    }
}

