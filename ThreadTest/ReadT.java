package ThreadTest;


public class ReadT implements Runnable {
    @Override
    public void run()
    {
        while (true)
        {
            long temp = MultiThreading.t;
            if(temp !=111L && temp !=-999L && temp!=890L && temp!=-444L)
            {
                System.out.println(temp);
            }
            else
            {
                System.out.println(temp);
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {

//        new Thread(new MultiThreading.ChangeTo(111L)).start();
//        new Thread(new MultiThreading.ChangeTo(-999L)).start();
//        new Thread(new MultiThreading.ChangeTo(890L)).start();
//        new Thread(new MultiThreading.ChangeTo(-444L)).start();
//        new Thread(new ReadT()).start();


        Thread t1 = new Thread(){
            @Override
            public void run()
            {
                while (true)
                {
                    if (currentThread().isInterrupted())
                    {
                        System.out.println("Interrupted");
                        break;
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }catch (InterruptedException e)
                    {
                        System.out.println("Interrupted when sleep");
                        currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };

        t1.start();
        Thread.sleep(200);
        t1.interrupt();
    }


}
