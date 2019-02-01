package ThreadTest;

import java.util.concurrent.*;

public class RegectThreadPoolDemo {
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
        ExecutorService service = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10), Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(System.currentTimeMillis() + " " + r.toString() + " is Discard");
                    }
                });
        for (int i = 0; i < 1000; i++) {
            service.submit(task);
            Thread.sleep(10);
        }

        service.shutdown();
    }
}
