package hello_world;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
public class Generators
{
    public  static <T> Collection<T> fill(Collection<T> coll, IGenerator<T> gen, int n)
    {
        for(int i=0; i< n; i++)
        {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args)
    {
        Collection<Coffee> coffees= fill( new ArrayList<Coffee>(),new CoffeeGenerator(),  4);
        for (Coffee c: coffees)
        {
            System.out.println(c);
        }
    }
}
