package hello_world;
import java.math.*;
public class test_BigInteger 
{
	public static void main(String[] args)
	{
		int a = Integer.MAX_VALUE;
		String b = String.format("%s", a);
		BigInteger ba = new BigInteger(b);
		BigInteger results = ba.multiply(ba);
		//BigInteger rr = ba*ba;  //The operator * is undefined for the argument type(s) java.math.BigInteger, java.math.BigInteger
		//BigInteger rr = ba + ba;  //The operator + is undefined for the argument type(s) java.math.BigInteger, java.math.BigInteger
		System.out.println(results);
	}
}
