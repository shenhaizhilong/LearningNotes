package JavaConcurrent;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/5 19:42
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    if(Thread.currentThread().isInterrupted())
                    {
                        System.out.println("current thread was interrupted");
                        break;
                    }
                    try{
                        System.out.println("sleeping 2s");
                        Thread.sleep(2000);
                    }catch (InterruptedException ex)
                    {
                        System.out.println("Interrupted when thread is sleeping");
                        //Thread.currentThread().interrupt(); // 如果注释这一行会无限循环,必须再次对当前线程设置中断
                        // 原因是抛出异常会清除中断标记，如果不加处理那么下一次循环，就无法捕获这个中断
                    }
                    Thread.yield();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
