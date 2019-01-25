package JavaConcurrent;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 13:33
 */
public class NoVisibility {
    private static boolean ready = false;
    private static int number = 10;
    private static class Task implements Runnable{
        @Override
        public void run() {
            while (!ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(1000);
        ready = true;
        Thread.sleep(1000);

    }
}
