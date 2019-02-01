package hello_world;
import java.util.*;
/**
 * Created by shenhaizhilong on 4/17/2017.
 */
public class TupleList<A,B,C,D> extends ArrayList<FourTuple<A,B,C,D>>
{
    public static void main(String[] args)
    {
        TupleList<Vehicle, Amphbian, String, Integer> t1 = new TupleList<>();
        t1.add(TupleTest.h());
        t1.add(TupleTest.h());

        for(FourTuple<Vehicle, Amphbian, String, Integer>  i: t1)
        {
            System.out.println(i);
        }
    }
}
