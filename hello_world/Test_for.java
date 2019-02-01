package hello_world;
import java.util.ArrayList;
public class Test_for 
{

	public static void main(String[] args)
	{
		ArrayList<Integer> List_a = new ArrayList<Integer>();
		
		for( int i =0; i < 10; i++)
		{
			/*Integer a = i;*/
			if( !List_a.contains(i))
				List_a.add(i);
		}
		
		for( Integer i: List_a)
		{
			System.out.println(i);
		}
		
		
	}
	
	
}
