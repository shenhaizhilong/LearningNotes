package suggestions151;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/26 11:44
 */
public class RandomDemo {
    public static void main(String[] args) {

//        Random random = new Random();
//        for (int i = 0; i < 4; i++) {
//            System.out.println(random.nextInt());
//        }
//
//        random = new Random(1000);
//        for (int i = 0; i < 4; i++) {
//            System.out.println(random.nextInt());
//        }

        System.out.println(seedUniquifier());

    }


   public static long seedUniquifier() {
        // L'Ecuyer, "Tables of Linear Congruential Generators of
        // Different Sizes and Good Lattice Structure", 1999
        for (;;) {
            long current = seedUniquifier.get();
            long next = current * 181783497276652981L;
            System.out.println(String.format("Current:%s, Next:%s", current, next));
            if (seedUniquifier.compareAndSet(current, next))
                return next;
        }
    }

    private static final AtomicLong seedUniquifier
            = new AtomicLong(8682522807148012L);
}
