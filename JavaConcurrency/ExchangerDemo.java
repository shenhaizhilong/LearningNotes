package JavaConcurrency;

import java.util.concurrent.Exchanger;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/13 11:28
 */
public class ExchangerDemo {
    private static final Exchanger<String>  exchanger = new Exchanger<>();

    private static class UserA implements Runnable
    {
        @Override
        public void run() {
            String str = "an apple";
            System.out.println(Thread.currentThread().getId() +" I have " + str);
            try
            {
                str = exchanger.exchange(str);
                System.out.println( Thread.currentThread().getId() + " after exchange I have " + str);
            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    private static class UserB implements Runnable
    {
        @Override
        public void run() {
            String str = "a banana";
            System.out.println(Thread.currentThread().getId() + " I have " + str);
            try
            {
                str = exchanger.exchange(str);
                System.out.println(Thread.currentThread().getId() +" after exchange I have " + str);
            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new UserA()).start();
        new Thread(new UserB()).start();
    }
}
