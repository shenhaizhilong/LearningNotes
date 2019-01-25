package suggestions151;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/26 15:56
 */
public class Base {
    private static int instanceNumber = 0;
    {
        ++instanceNumber;
    }

    public Base()
    {

    }

    public Base(int i)
    {

    }

    public Base(String str)
    {
        this();
    }


    public int getInstanceNumber()
    {
        return instanceNumber;
    }


    public static void main(String[] args) {
        new Base();
        new Base(0);
        Base base =  new Base("str");
        System.out.println(base.getInstanceNumber());

    }
}
