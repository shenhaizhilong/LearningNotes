package hello_world;

/**
 * Created by shenhaizhilong on 5/8/2017.
 */
public class Mule implements IHorse,IDonkey,IAnimal
{
    public void eat()
    {
        System.out.println("Mule eat");
    }
    public void run()
    {
        IHorse.super.run();
    }
    public static void main(String[] args)
    {
        Mule mule = new Mule();
        mule.run();
        mule.eat();
        mule.breath();
    }
}
