package hello_world;

/**
 * Created by shenhaizhilong on 5/8/2017.
 */
public interface IAnimal
{
    default void breath()
    {
        System.out.println(" breath");
    }
}
