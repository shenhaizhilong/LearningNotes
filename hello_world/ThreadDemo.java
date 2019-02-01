package hello_world;

public class ThreadDemo {

    public static void main(String[] args) {
        Thread thread = null;

        Runnable runnable = ()-> {
                System.out.println(Thread.currentThread().getId());
                try
                {
                    Thread.sleep(100000);
                }catch (InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }

        };

        for (int i = 0; i < 1000; i++) {
            thread = new Thread(runnable);
            thread.start();
        }

        try
        {
            Thread.sleep(20000);
        }catch (InterruptedException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
