package ThreadTest;

public class AccountIngVol implements Runnable {

    static AccountIngVol instance = new AccountIngVol();
    static volatile int i=0;
    public void increase()
    {
        synchronized (instance)
        {
            i++;
        }

    }
    @Override
    public void run()
    {
        for (int j = 0; j < 10000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(instance);
        Thread t2 = new Thread(instance);
        thread.start();

        t2.start();
        thread.join();
        t2.join();

        System.out.println(i);
    }
}
