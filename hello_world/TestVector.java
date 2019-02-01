package hello_world;
import java.util.*;
public class TestVector 
{
	public static void main(String[] args)
	{
		Vector<Integer> vt = new Vector<Integer>();
		for( int i = 0; i <=200; i++)
		{
			 vt.addElement(i);
			 System.out.printf("the capacity of vt are: %d\n", vt.capacity());
		}
		System.out.printf("the size of vt are: %d\n", vt.size());
		System.out.printf("the capacity of vt are: %d\n", vt.capacity());
		for( Integer i: vt)
		{
			System.out.println(i);
		}
		for( int i: vt)
		{
			System.out.println(i);
		}
	}

}
