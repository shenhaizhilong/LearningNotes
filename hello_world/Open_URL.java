package hello_world;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Open_URL 
{
	public static void main(String[] args)
	{
		String site = "http://www.guancha.cn";
		String site2 = "just a test";
		String input = "1 fish 2 fish red fish blue fish";
		
		Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
		System.out.println(s.nextInt());
		System.out.println(s.nextInt());
		System.out.println(s.next());
		System.out.println(s.next());
		s.close();

	    
	     Scanner ss = new Scanner(input);
	     ss.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
	     MatchResult result = ss.match();
	     for (int i=1; i<=result.groupCount(); i++)
	         System.out.println(result.group(i));
	     ss.close();
	     
		Print_web(site);
	}
	
	public static void Print_web(String site)
	{
		try
		{
			int count = 0;
			URL url = new URL(site);
			Scanner input = new Scanner(url.openStream());
			while(input.hasNext())
			{
				count++;
				System.out.println(input.nextLine());
				
				
			}
			
			System.out.println("the sum number of this web page are " + count);
			input.close();
		}
		catch(java.net.MalformedURLException ex)
		{
			System.out.println("invaild URL" + site);
			ex.printStackTrace();
			
		}
		catch(java.io.IOException ex)
		{
			System.out.println(" Io error: No such file");
		}

	}
}
