package hello_world;

/**
 * Created by shenhaizhilong on 5/8/2017.
 */
public interface IHorse
{
    public void eat();
    default void run()
    {
        System.out.println("Horse run");
    }
}

