package JavaConcurrent;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/13 13:14
 */
public class CaughtExceptionHandlerDemo {

    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Uncaught exception: " + e.getMessage());
            }
        };
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Sleeping......");
                try
                {
                    Thread.sleep(1000*1);
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
                throw new RuntimeException(" Runtime Exception");
            }
        });
        thread.setUncaughtExceptionHandler(handler);
        thread.start();
    }
}
