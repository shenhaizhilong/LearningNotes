package JavaConcurrency;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/5 18:42
 */
public class Sequence {
    private int value;
    public synchronized int getNext()
    {
        return value++;
    }
}
