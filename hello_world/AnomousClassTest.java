package hello_world;


public class AnomousClassTest
{
    public final int value =4;
    public void doIt()
    {
        int value=6;
        Runnable rnnnable = new Runnable(){
            public final int value = 5;
            public void run()
            {
                int value = 10;
                System.out.println(this.value);
            }
        };
        rnnnable.run();
    }

    public static void main(String[] args)
    {
        AnomousClassTest anomousClassTest = new AnomousClassTest();
        anomousClassTest.doIt();
    }
}
