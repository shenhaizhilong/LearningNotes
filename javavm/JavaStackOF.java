package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/16 11:43
 *
 * 虚拟机栈溢出
 */
public class JavaStackOF {

    private int stackLength = 0;

    public void stackLeak(int x, int y)
    {
        stackLength++;
        stackLeak(10,1);
    }

    public static void main(String[] args) {

        JavaStackOF stackOF = new JavaStackOF();
        try
        {
            stackOF.stackLeak(10,11);
            // StackOverflowError 这是error， 捕捉Exception  无法捕捉到，所以用Throwable
        }catch (Throwable e)
        {
            System.out.println(e.getMessage());
            System.out.println("Stack length is : " + stackOF.stackLength);
            throw e;
        }
    }
}
