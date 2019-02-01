package ThreadTest;


public class ThreadStop extends Thread {
    private int i=0;
    @Override
    public void run()
    {
        try {

            while (true) {
                i++;
                System.out.println("i= " + i);
                Thread.sleep(100);
            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try
        {
            ThreadStop threadStop = new ThreadStop();
            threadStop.start();
            Thread.sleep(800);
            threadStop.stop();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
