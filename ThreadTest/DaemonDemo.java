package ThreadTest;


public class DaemonDemo extends Thread{

    @Override
    public void run()
    {
        while (true)
        {
            System.out.println("I am alive");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        DaemonDemo daemonDemo = new DaemonDemo();
        daemonDemo.setDaemon(true);
        daemonDemo.start();
        Thread.sleep(2000);
    }
}
