package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/16 18:48
 */
public class SaveOnce {
    private static SaveOnce save_hook  = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize method executed");
        save_hook = this;
    }

    public static void main(String[] args) throws InterruptedException  {

        save_hook = new SaveOnce();
        save_hook = null;
        System.gc();
        Thread.sleep(500);
        if(save_hook != null)
        {
            System.out.println("I am still alive");
        }else {
            System.out.println("I am dead");
        }

        save_hook = null;
        System.gc();
        Thread.sleep(500);
        if(save_hook != null)
        {
            System.out.println("I am still alive");
        }else {
            System.out.println("I am dead");
        }
    }
}
