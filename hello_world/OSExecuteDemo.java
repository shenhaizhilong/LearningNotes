package hello_world;

/**
 * Created by shenhaizhilong on 4/29/2017.
 */
public class OSExecuteDemo
{
    public static void main(String[] args)
    {
        OSExecute.command("javap F:\\Users\\shenhaizhilong\\Test\\out\\production\\Test\\hello_world\\OSExecuteDemo.class");
        OSExecute.command("dir");
        OSExecute.command("del test2.txt");
        OSExecute.command("dir");
    }
}
