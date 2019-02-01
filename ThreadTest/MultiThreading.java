package ThreadTest;


public class MultiThreading
{
    public static  long t =0;
    public static class ChangeTo implements Runnable
    {
        private long to;
        public ChangeTo(long to)
        {
            this.to = to;
        }
        @Override
        public void run()
        {
            while (true)
            {
                MultiThreading.t = to;
                Thread.yield();
            }
        }
    }
}
