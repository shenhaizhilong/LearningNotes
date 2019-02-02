package JavaConcurrency;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/5 18:21
 */

public class UnSafeSequence {

    private int value;

    public int getNext() {
        return value++;
    }
}
