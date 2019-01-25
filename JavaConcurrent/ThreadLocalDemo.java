package JavaConcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/13 11:04
 */
public class ThreadLocalDemo {
    private static final AtomicInteger nextId = new AtomicInteger(0);

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
                System.out.println("id:" + ThreadLocalDemo.get());
            }
        };
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            service.submit(runnable);
        }
        service.shutdown();
    }
}
