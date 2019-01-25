package JavaConcurrent;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/5 18:42
 */
public class SequenceTest {

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(sequence.getNext());
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
