package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/23 9:43
 */
public abstract class AbstractClassDemo {
    protected int val;
    public AbstractClassDemo(int val)
    {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public abstract  int getSquare();
}
