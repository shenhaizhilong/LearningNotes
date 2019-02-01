package ThreadTest;

public class ReturnStopThread extends Thread {
    @Override
    public void run()
    {
        while (true)
        {
            System.out.println("Timer: " + System.currentTimeMillis());
            if(this.isInterrupted()){
                System.out.println("Interrupted ");
                return;
            }
        }
    }

    public static void main(String[] args) {
        ReturnStopThread returnStopThread = new ReturnStopThread();
        returnStopThread.start();
        try
        {
            Thread.sleep(2000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        returnStopThread.interrupt();
    }
}
