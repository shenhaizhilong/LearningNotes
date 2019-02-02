package JavaConcurrency;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 13:37
 */
public class Visibility {

    private static volatile boolean ready = false;
    private static int number = 10;
    private static class Task implements Runnable{
        @Override
        public void run() {
            while (!ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Task()).start();
        Thread.sleep(1000);
        ready = true;
        Thread.sleep(1000);

    }
}
