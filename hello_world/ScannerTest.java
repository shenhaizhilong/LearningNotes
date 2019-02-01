package hello_world;
import java.util.regex.*;
import java.util.*;
public class ScannerTest
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner("12,23,34,44,55,10.0");
		scanner.useDelimiter("\\s*,\\s*");
		while(scanner.hasNextInt())
		{
			System.out.println(scanner.nextInt() +1);
		}
		
		
	}
}
