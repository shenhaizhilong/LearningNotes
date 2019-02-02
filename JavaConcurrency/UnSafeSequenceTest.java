package JavaConcurrency;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/5 18:29
 */
public class UnSafeSequenceTest {

    public static void main(String[] args) {
        UnSafeSequence unSafeSequence = new UnSafeSequence();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(unSafeSequence.getNext());
            }
        };

        int count = 3000;
        Thread[] threads = new Thread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < count; i++) {
            threads[i].start();
        }

    }
}
