package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
public class CountedObject
{
    private  static  long counter =0;
    private  final  long id = counter++;
    public  long ID(){
        return  id;
    }

    public String toString()
    {
        return "CountedObject " + id;
    }
}

