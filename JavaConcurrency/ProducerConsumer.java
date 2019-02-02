package JavaConcurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/30 19:24
 */
public class ProducerConsumer {
    private static BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>();
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static class Producer extends Thread
    {
        @Override
        public void run() {
            try
            {

                for (int i = 0; i < 10; i++) {
                   int val = atomicInteger.incrementAndGet();
                    blockingQueue.put(val);
                    System.out.println("produce : " + val);
                }
            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }

        }
    }

    private static class Consumer extends Thread
    {
        @Override
        public void run() {
            while (atomicInteger.intValue() > 0)
            {
                System.out.println("consume : " + blockingQueue.poll());
                atomicInteger.getAndDecrement();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Producer producer = new Producer();
            producer.start();
        }

        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }
    }
}
