package javavm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/22 23:03
 */
public class AtomicityTest implements Runnable {
    private int i = 0;
    public int getI()
    {
        return i;
    }

    private synchronized void increase()
    {
        i++;
        i++;
    }
    @Override
    public void run() {

            while (true) {
                increase();
            }

    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(20);
        AtomicityTest test = new AtomicityTest();
        service.submit(test);
        while (true)
        {
            int v = test.getI();
            if((v & 0x01) == 1) System.out.println(v);
        }

    }
}
