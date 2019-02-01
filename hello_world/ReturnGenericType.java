package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
public class ReturnGenericType<T extends HasF>
{
    private T obj;
    public ReturnGenericType(T x) { obj = x;}
    public T get(){return  obj;}
}
