package hello_world;
import java.util.*;
public class containertest {
	
public static void main(String[] args)
{
	//Collection<Integer> c = new ArrayList<Integer>();
	//Collection<Integer> c = new HashSet<Integer>();
	//Collection<Integer> c = new TreeSet<Integer>();
	Collection<Integer> c = new LinkedHashSet<Integer>();
	for(int i=0; i < 10; i++)
	{
		c.add(i);
	}
	for(int i=0; i < 10; i++)
	{
		c.add(i);
	}
	
	for(Integer i:c)
	{
		System.out.println(i);
	}
	
	Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,0,1,2,3,5,10));
	for(Integer i: collection)
	{
		System.out.println(i);
	}
	
	Collection<String> cs = new ArrayList<String>();
	Collections.addAll(cs, "Take the long way home".split(" "));
	for(String word:cs)
	{
		System.out.println(word);
	}
}
}
