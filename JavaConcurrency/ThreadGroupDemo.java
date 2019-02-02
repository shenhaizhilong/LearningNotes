package JavaConcurrency;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 14:22
 */
public class ThreadGroupDemo {

    private static class ThreadGroupTask implements Runnable
    {
        @Override
        public void run() {
            String groupName = Thread.currentThread().getThreadGroup().getName();
            while (true)
            {
                System.out.println("Thread group:" + groupName + ", " + Thread.currentThread().getName());
                try
                {
                    Thread.sleep(1000);
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Print Group");
        Thread t1 = new Thread(group, new ThreadGroupTask(),"t1");
        Thread t2 = new Thread(group, new ThreadGroupTask(), "t2");
        t1.start();
        t2.start();
        System.out.println(group.activeCount());
        group.list();
    }
}
