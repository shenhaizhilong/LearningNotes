package hello_world;

public class TestGCD 
{
	public static void main(String[] args)
	{
		System.out.println(gcd(10,1));
		System.out.println(gcd(10,5));
		System.out.println(gcd(5,10));
		System.out.println(gcd(5,0));
	}
	
	public  static int gcd(int m, int n)
	{
		if( m %n ==0)
			return n;
		else
		{
			return gcd(n, m % n);
		}
	}

}
