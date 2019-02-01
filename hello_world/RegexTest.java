package hello_world;
import java.util.regex.*;
import java.util.*;
import java.util.Map.Entry;

public class RegexTest {

	public static void main(String[] args)
	{
		Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
		while(m.find())
		{
			System.out.println(m.group() + " ");
		}
		
		
		Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
		Matcher mm = p.matcher("java has regex\njava has regex\njava has regex\n" + "JAVA HAS REGEX\n");
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		while(mm.find())
		{
			System.out.println(mm.group());
			if(map.containsKey(mm.group()))
			{
				int value = map.get(mm.group());
				value = value +1; 
				map.put(mm.group(), value);
			}
			else
			{
				map.put(mm.group(), 1);
			}
		}
		
		Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
		while(iter.hasNext())
		{
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)iter.next();
			System.out.println(entry.getKey() +"," +  entry.getValue());
		}

		for(Entry<String, Integer> myentry : map.entrySet())
		{
			System.out.println(myentry.getKey()+ "," + myentry.getValue());
		}
		
		String input = "This !! unusual use !!of ex !!points";
		System.out.println(Arrays.toString(Pattern.compile("!").split(input)));
		System.out.println(Arrays.toString(Pattern.compile("!!").split(input,3)));
	}
}
