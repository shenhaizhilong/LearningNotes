package ThreadTest;

public class ThreadGroupName implements Runnable {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("HttpHandler");
        Thread thread = new Thread(tg, new ThreadGroupName(), "T1");
        Thread thread1 = new Thread(tg, new ThreadGroupName(), "T2");
        thread.start();
        thread1.start();
        System.out.println(tg.activeCount());
        tg.list();
    }

    @Override
    public void run()
    {
        String groupANdName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
        while (true)
        {
            System.out.println("I am " + groupANdName);
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }
}
