package JavaConcurrency;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 14:05
 */
public class JoinDemo {
    private static volatile int counter = 0;

    public static class Increase extends Thread
    {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Increase increase = new Increase();
        increase.start();
        // 主线程别急，等我干完活，你再继续；否则，你就等着吧！
        increase.join(); // after running thread increase, then print counter, if no join() counter will be zero;
        // increase not have enough time to run

        System.out.println("counter = " + counter);
    }
}
