package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
public class Tuple
{
    public  static <A> OneTuple<A> tuple(A a)
    {
        return new OneTuple<>(a);
    }
    public  static <A,B> TwoTuple<A,B> tuple(A a, B b)
    {
        return  new TwoTuple<>(a,b);
    }
    public static <A,B,C> ThreeTuple<A,B,C> tuple(A a, B b, C c)
    {
        return  new ThreeTuple<>(a, b, c);
    }

    public static <A, B, C, D> FourTuple<A,B,C,D> tuple(A a, B b, C c, D d)
    {
        return new FourTuple<>(a, b, c, d);
    }
    public static  <A, B, C, D, E> FiveTuple<A, B,C, D, E> tuple(A a, B b, C c, D d, E e)
    {
        return  new FiveTuple<>(a, b, c, d,e);
    }
}
