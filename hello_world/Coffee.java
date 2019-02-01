package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
public class Coffee
{
    //辉辉
    private  static  long counter = 0;
    private  final  long id = counter++;
    public  String toString()
    {
        return getClass().getSimpleName() + " " + id;
    }
}

