package hello_world;
import java.util.*;
public class TestSet {

	public static void main(String[] args)
	{
		Set<String> myset1 =  new HashSet<String>();
		myset1.add("Beijing");
		myset1.add("ShangHai");
		myset1.add("LongDong");
		myset1.add("Bari");
		myset1.add("Moscow");
		myset1.add("Moscow");
		System.out.println(myset1);
		Set<Integer> myset2 = new LinkedHashSet<Integer>();
		for(int i = 10; i >= 1; i--)
		{
			myset2.add(i);
		}
		myset2.add(15);
		System.out.println(myset2);
		Set<Integer> myset3 = new TreeSet<Integer>();
		for(int i = 10; i >= 1; i--)
		{
			myset3.add(i);
		}
		
		System.out.println(myset3);
		
		TreeSet<String> treeset = new TreeSet<String>();
		treeset.add("Bei Jing");
		treeset.add("Shang Hai");
		treeset.add("Guang Dong");
		treeset.add("Bei Jing");
		treeset.add("Hu Bei");
		treeset.add("Parid");
		treeset.add("Paris");
		System.out.println(treeset);
		
		for(Object o: treeset)
		{
			System.out.println(o.toString());
		}
		
		for(String o: treeset)
		{
			System.out.print(o + ", ");
		}
		
		HashSet<Object> hashset = new HashSet<Object>();
		hashset.add(10);
		hashset.add("Bei Jing");
		System.out.println("");
		for(Object o: hashset)
		{
			System.out.print(o);
		}
		
	}
	
}
