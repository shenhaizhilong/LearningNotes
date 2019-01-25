package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/23 9:46
 *
 * 如果没有显示调用定义的构造器，而且父类又定义了构造器，这里会无法编译
 */
public class AbstractSubClass extends AbstractClassDemo {

    public AbstractSubClass(int val)
    {
        super(val);
    }
    @Override
    public int getSquare() {
        return this.val*this.val;
    }

    public static void main(String[] args) {
        AbstractSubClass subClass = new AbstractSubClass(10);
        System.out.println(subClass.getSquare());
    }
}
