package hello_world;
import java.util.*;

class Amphbian
{
	
}

class Vehicle
{
	
}
class OneTuple<T> {
	public final T first;
	public OneTuple(T a)
	{
		this.first = a;
	}
	public String toString()
	{
		return "(" + first +")";
	}
}

 class TwoTuple<A,B> 
{
	public final A first;
	public final B second;
	public TwoTuple(A a, B b)
	{
		this.first = a;
		this.second = b;
	}
	
	public String toString()
	{
		return "(" + first + "," + second + ")";
	}
}
 


class ThreeTuple<A,B,C> extends TwoTuple<A,B>
{
	public final C third;
	public ThreeTuple(A a, B b, C c)
	{
		super(a,b);
		this.third = c;
	}
	
	public String toString()
	{
		return "(" + first + "," + second + "," + third + ")";
	}
	
}

class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C>
{
	public final D fourth;
	public FourTuple(A a, B b, C c, D d)
	{
		super(a,b,c);
		this.fourth = d;
	}
	
	public String toString()
	{
		return "(" + first + "," + second + "," + third + "," + fourth + ")";
	}
}

class FiveTuple<A,B,C,D, E> extends FourTuple<A,B,C,D>
{
	public final E fifth;
	public FiveTuple(A a, B b, C c, D d, E e)
	{
		super(a,b,c,d);
		this.fifth = e;
	}
	
	public String toString()
	{
		return "(" + first + "," + second + "," + third + "," + fourth + "," + fifth + ")";
	}
}


public class TupleTest
{
	static TwoTuple<String, Integer> f() {
		return new TwoTuple<String, Integer>("hi", 100);
	}
	
	static ThreeTuple<Amphbian, String, Integer> g()
	{
		return new ThreeTuple<Amphbian, String, Integer>(new Amphbian(), "three", 3);
	}
	
	
	static FourTuple<Vehicle, Amphbian, String, Integer> h()
	{
		return new FourTuple<Vehicle, Amphbian, String, Integer>(new Vehicle(), new Amphbian(), "hi", 30);
		
	}
	
	static FiveTuple<Vehicle, Amphbian, String, Integer, Double> k()
	{
		return new FiveTuple<Vehicle, Amphbian, String, Integer, Double>(new Vehicle(), new Amphbian(), "hi", 30, 11.1);
		
	}
	
	
	public static void main(String[] args)
	{
		TwoTuple<String, Integer> tt = f();
		//tt.first = "100";
		System.out.println(tt);
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
		System.out.println((Integer) 10==null);
		
	}
	
}