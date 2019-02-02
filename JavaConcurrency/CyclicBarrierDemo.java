package JavaConcurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/30 11:59
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int count = 5;
          CyclicBarrier barrier = new CyclicBarrier(count, ()-> System.out.println("barrier action "));
        ExecutorService service = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            service.execute(()-> {
                System.out.println("number waiting: " + barrier.getNumberWaiting());
                try{
                    barrier.await();
                }catch (BrokenBarrierException | InterruptedException ex)
                {
                    ex.printStackTrace();
                }
                System.out.println("do the work");

            });
        }

        barrier.reset();  // 循环使用
        for (int i = 0; i < count; i++) {
            service.execute(()-> {
                try{
                    barrier.await();
                }catch (BrokenBarrierException | InterruptedException ex)
                {
                    ex.printStackTrace();
                }
                System.out.println("do the work 2");

            });
        }
        service.shutdown();
    }
}
