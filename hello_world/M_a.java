package hello_world;

public class M_a 
{
	boolean x;
	int a;
	String[] s;
	
	public static void main(String[] args)
	{
		int x;
		String y;
		M_a a = new M_a();
		System.out.println(a.x);   //false
		System.out.println(a.a);   //0
		System.out.println(a.s);   //null
		//System.out.println( b);
		//System.out.println("x is " + x);   //The local variable y may not have been initialized
		//System.out.println("y is " + y);
		
	}
}

