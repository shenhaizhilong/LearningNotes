package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
public class TupleTest2
{
    static OneTuple<String> one() {return Tuple.tuple("hi");}
    static TwoTuple<String, Integer> f(){return  Tuple.tuple("HI", 2);}
    static  TwoTuple f2(){return Tuple.tuple("Hi", 2);}
    static  ThreeTuple<Amphbian, String, Integer> g()
    {
        return   Tuple.tuple(new Amphbian(), "hi", 3);
    }
    static FourTuple<Vehicle, Amphbian, String, Integer> h()
    {
        return Tuple.tuple(new Vehicle(), new Amphbian(), "hi", 4);
    }

    static  FiveTuple<Vehicle, Amphbian, String, Integer, Double> k()
    {
        return Tuple.tuple(new Vehicle(), new Amphbian(), "hi", 5, 5.0);
    }

    public  static  void  main(String[] args)
    {
        System.out.println(one());
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());

    }
}
