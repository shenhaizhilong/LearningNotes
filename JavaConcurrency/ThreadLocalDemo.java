package JavaConcurrency;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/13 11:04
 */
public class ThreadLocalDemo {
    private static final AtomicInteger nextId = new AtomicInteger(11);

    private static ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };


    public static int get()
    {
        return threadId.get();
    }

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("thread id:" + ThreadLocalDemo.get() + " ," + Thread.currentThread().getId());
            }
        };
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(runnable);
        }
        service.shutdown();
        System.out.println(UUID.randomUUID());
    }
}
