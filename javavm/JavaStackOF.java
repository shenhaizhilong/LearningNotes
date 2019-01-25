package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/16 11:43
 */
public class JavaStackOF {

    private int stackLength = 0;

    public void stackLeak()
    {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {

        JavaStackOF stackOF = new JavaStackOF();
        try
        {
            stackOF.stackLeak();
        }catch (Throwable e)
        {
            System.out.println(e.getMessage());
            System.out.println("Stack length is : " + stackOF.stackLength);
            throw e;
        }
    }
}
