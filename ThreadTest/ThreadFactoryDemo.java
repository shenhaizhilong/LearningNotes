package ThreadTest;

import java.util.concurrent.*;

public class ThreadFactoryDemo {
    public static class MyTask implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                System.out.println(System.currentTimeMillis() + " Thread:ID " + Thread.currentThread().getId());
                Thread.sleep(100);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        ExecutorService service = new ThreadPoolExecutor(5, 100, 0L, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                System.out.println("Created " + t);
                return t;
            }
        });

        for (int i = 0; i < 50; i++) {
            service.submit(task);
        }

        Thread.sleep(2000);
        char[] chars = {31354,22478, 35745};
        System.out.println((char)chars[0] + (char)chars[1] + (char)chars[2]);
        for (int i = 0; i < chars.length; i++) {
            System.out.println((char)chars[i]);
        }
    }
}
