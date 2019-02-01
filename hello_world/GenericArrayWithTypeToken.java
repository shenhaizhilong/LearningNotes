package hello_world;

import java.lang.reflect.Array;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
public class GenericArrayWithTypeToken<T>
{
    private T[] array;
    public GenericArrayWithTypeToken(Class<T> type, int sz)
    {
        array = (T[]) Array.newInstance(type, sz);
    }
    public void put(int index, T item)
    {
        array[index] = item;
    }
    public T get(int index)
    {
        return array[index];
    }
    public T[] rep(){return  array;}
    public static void main(String[] args)
    {
        int sz = 1000;
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, sz);
        for(int i=0; i< sz; i++)
        {
            gai.put(i,i);
        }
        Integer[] ia = gai.rep();
       for (int i: ia)
       {
           System.out.println(i);
       }
    }
}
