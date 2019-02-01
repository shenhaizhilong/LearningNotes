package hello_world;

public class get_gcd {

	public static void main(String[] args)
	{
		int n1 = 4;
		int n2 = 8;
		int b = 1;
	    
/*		for( int k =2; k <= n1/2 || k<= n2/2; k++ )
		{
			if( n1 % k ==0 && n2 % k == 0)
			{
				gcd = k;
				
			}
			
		}*/
/*		b = get_gcd( n1, n2);
		System.out.println(b);*/
		
		System.out.println(gcd(5,0));
		System.out.println(gcd(7,10));
		
		
		
	}
	
	private static int gcd(int p, int q)
	{
		if(q ==0) return p;
		int r = p%q;
		return gcd(q, r);
	}
	
	public static int get_gcd( int n1, int n2)
	{
		int gcd = 1;
	    
		for( int k =2; k <= n1/2 || k<= n2/2; k++ )
		{
			if( n1 % k ==0 && n2 % k == 0)
			{
				gcd = k;
				
			}
			
		}
		return gcd;
		
	}
}
