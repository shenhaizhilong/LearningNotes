package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/18 22:49
 */
public class DeadLock implements Runnable {
    int a;
    int b;

    public DeadLock(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a))
        {
            synchronized (Integer.valueOf(b))
            {
                System.out.println(a + b);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new DeadLock(1,2)).start();
            new Thread(new DeadLock(2,1)).start();
        }
    }
}
