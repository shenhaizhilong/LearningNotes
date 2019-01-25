package JavaConcurrent;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 13:25
 */
public class VolatileNoAtomicity  {
    private static volatile long counter = 0;

   public static class IncreaseTask implements Runnable{

       @Override
       public void run() {
           for (int i = 0; i < 1000; i++) {
               counter++;
           }
       }
   }

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new IncreaseTask());
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        System.out.println(counter);
    }
}
