package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/22 22:42
 */
public class IntAtomicityDemo {
    private static volatile int x,y,z,k;

    public static class Task implements Runnable
    {
        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                x++;
            }

            for (int i = 0; i < 50000; i++) {
                ++y;
            }

            for (int i = 0; i < 50000; i++) {
                z = z + 1;
            }

            for (int i = 0; i < 50000; i++) {
                k += 1;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);
        System.out.println("k = " + k);
    }


}
