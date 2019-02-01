package hello_world;
import java.util.ArrayList;
public class Test_ArrayList 
{
	public static void main(String[] args)
	{
		ArrayList<String> CityList = new ArrayList<>();
		String city;
		for(int i = 0; i < 10 ;i++)
		{
			city = String.format("%s", i);
			CityList.add(city);
		}
		
		System.out.println(CityList.size());
		// display all the element in the ArrayList instance
		System.out.println(CityList.toString());
		System.out.println(CityList);

	/*	// display all the element in the ArrayList in  reverse order
		for(int i = CityList.size() - 1; i >= 0; i--)
		{
			System.out.println(CityList.get(i));
		}*/
		
	}
	
}
