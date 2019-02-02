package JavaConcurrency;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/5 18:47
 *
 * Run time Environment: 32 bit JVM
 * check atomicity
 */
public class MultiThreadLong {
    private static long value = 0;
    public static class ChangeValue implements Runnable
    {
        private long to;
        public ChangeValue(long to)
        {
            this.to = to;
        }
        @Override
        public void run() {
            while (true)
            {
                MultiThreadLong.value = this.to;
                Thread.yield();
            }
        }
    }

    public static class ReadValue implements Runnable
    {
        @Override
        public void run() {
            while (true)
            {
                long temp = MultiThreadLong.value;
                if(temp != 111L && temp != -999L && temp != 333L && temp != -444L)
                {
                    System.out.println(temp);
                }
                Thread.yield();
            }
        }
    }


    public static void main(String[] args) {
        new Thread(new ChangeValue(111L)).start();
        new Thread(new ChangeValue(-999L)).start();
        new Thread(new ChangeValue(333L)).start();
        new Thread(new ChangeValue(-444L)).start();
        new Thread(new ReadValue()).start();
    }
}
