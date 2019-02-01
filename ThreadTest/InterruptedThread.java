package ThreadTest;


public class InterruptedThread extends Thread {

    @Override
    public void run()
    {
        for (int i = 0; i < 50000; i++) {
            System.out.println("i=" + i);
        }
        try {
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        }catch (InterruptedException e)
        {
            System.out.println("stopped when the thread is sleep " + this.isInterrupted());
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        InterruptedThread interruptedThread = new InterruptedThread();
        interruptedThread.start();
        try {
            Thread.sleep(1000);
            interruptedThread.interrupt();
            System.out.println("Is Interrupted " +  interruptedThread.isInterrupted());
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }


    }
}
