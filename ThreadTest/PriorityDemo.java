package ThreadTest;


public class PriorityDemo {

    public static class HighPriority extends Thread
    {
        private int count =0;
        @Override
        public void run()
        {
            synchronized (PriorityDemo.class)
            {
                while (true)
                {
                    if (count>10000)
                    {
                        System.out.println("HighPriority completed");
                        break;
                    }
                    count++;

                }
            }
        }
    }

    public static class LowPriority extends Thread
    {
        private int count =0;
        @Override
        public void run()
        {
            synchronized (PriorityDemo.class)
            {
                while (true)
                {
                    count++;
                    if(count>10000)
                    {
                        System.out.println("Low Priority completed");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        HighPriority highPriority = new HighPriority();
        LowPriority lowPriority = new LowPriority();
        highPriority.setPriority(Thread.MAX_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);
        lowPriority.start();
        highPriority.start();
    }
}
