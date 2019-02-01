package hello_world;
import java.util.*;

public class TestSet2 
{
	public static void main(String[] args)
	{
		 Set<String> myset1 =  new HashSet<String>();
		 Collection<String> myset2 =  new HashSet<String>();
		 Collection<String> myset3 =  new TreeSet<String>();
		 Collection<String> myset4 =  new LinkedHashSet<String>();
		 Collection<String> myset5 =  new Vector<String>();
		 Collection<String> myset6 =  new LinkedList<String>();
		 Collection<String> myset7 =  new ArrayList<String>();
		 Collection<String> myset9 =  new Stack<String>();
		 print_collection_item(myset1);
		 print_collection_item(myset2);
		 print_collection_item(myset3);
		 print_collection_item(myset4);
		 print_collection_item(myset5);
		 print_collection_item(myset6);
		 print_collection_item(myset7);
		 print_collection_item(myset9);
		 
		
	}

	public String foo(String text)
	{
		if(text==null)
		{
		}
		else {
			text+="x";
			text +="a";
			text="";
		}
		return text;
	}
	public static  void print_collection_item(Collection<String> C)
	{
		C.add("Beijing");
		C.add("ShangHai");
		C.add("LongDong");
		C.add("Bari");
		C.add("Moscow");
		C.add("Moscow");
		System.out.println("*************************************************");
		System.out.println(C);
		//obtain an iterator for the set
		Iterator<String> iter = C.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next().toString());
		}
		
	}
}
