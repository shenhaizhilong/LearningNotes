package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */

public class BasicGenerator<T> implements IGenerator<T>
{
    private  Class<T> type;
    public  BasicGenerator(Class<T> type){this.type = type;}
    public T next()
    {
        try
        {
            return  type.newInstance();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }


    }

    public static <T>  IGenerator<T> create(Class<T> type)
    {
        return new BasicGenerator<T>(type);
    }

}
