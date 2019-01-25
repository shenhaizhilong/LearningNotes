package pocketJava8;

import java.util.BitSet;

/**
 * @author: shenhaizhilong
 * @date: 2018/9/8 19:15
 */
public class BitSetDemo {

    public static void main(String[] args) {

        BitSet bitSet = new BitSet(31);
        bitSet.set(Integer.MAX_VALUE);
        System.out.println(bitSet.size());
    }
}
