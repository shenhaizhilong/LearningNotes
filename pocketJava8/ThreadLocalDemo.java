package pocketJava8;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/22 10:43
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> sum = new ThreadLocal<>();


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if(sum.get() == null)
                    {
                        sum.set(0);
                    }
                    sum.set(sum.get() +1);
                    try
                    {
                        System.out.println(sum.get());
                        Thread.sleep(10);

                    }catch (Throwable e)
                    {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        System.out.println(sum.get());

        /*
        String a = "hello";
        String b = "he" + new String("llo");
        System.out.println(a == b);
        */
    }
}
