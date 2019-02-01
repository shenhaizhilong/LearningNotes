package hello_world;

public class test_base_type 
{
	public static void main(String[] args)
	{
		//test Integer
		Integer i = new Integer("23");
		//Integer j = new Integer(20.3);  //the constructor Integer(double) is undefined
		Integer k = new Integer(20);
		Integer m = Integer.valueOf("23");
		Integer n = Integer.valueOf("12");
		
		//test Double
		//Double d =  new Double();  //the constructor Double() is undefined.
		Double aa = new Double(20);
		Double ab = new Double(20.3);
		Double ac = new Double("20.3");
		Double ad = new Double("20");
		int ai = (Integer.valueOf("20")).intValue();
		String a = String.format("%x", 26);
		
		System.out.println(ai);
		
		Integer add = 3;
		Integer x = 3 + new Integer(10);
		System.out.println(x);
		//Double abc = 3; //Type mismatch: cannot convert from int to Double
		Double abd = 3.0;
		int xx = new Integer(3);
		Double ax = (double) 3;
		System.out.println(xx);
		int y = new Integer(3) + new Integer(3);
		System.out.println(y);
		
	}
}
