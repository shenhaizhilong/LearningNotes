package hello_world;

public class myoverride 
{
	public static void main(String[] args)
	{
		B b = new B();
		b.p(10.0);
		b.p(10);
		C c = new C();
		c.p(10);
		c.p(10.0);
		A a = new A();
		A aa = new B();
		
		//      A
		//      ^
		//      |
		//      B
/*		System.out.println( b instanceof B);
		System.out.println( a instanceof B);
		System.out.println( b instanceof A);
		System.out.println( a instanceof A);*/
		System.out.println( aa instanceof A);
		System.out.println( aa instanceof B);
	}

}

class A 
{
	public void p(double a)
	{
		System.out.println(a);
	}
}

class B extends A
{
	// this method overrides the method in class A
	
	@Override
	public void p(double a)
	{
		
		System.out.println(2*a);
	}

}

class C extends A
{
	public void p(int a)
	{
		// this method overloads the method in A
		System.out.println(a*a);
	}

}
