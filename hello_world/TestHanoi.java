package hello_world;

public class TestHanoi 
{
	public static void main(String[] args)
	{
		int n = 10;
		moveDisk(n, 'A', 'B','C');
	}
	
	public static void moveDisk(int n, char fromTower, char toTower, char auxTower)
	{
		if(n < 1)
		{
			System.out.println(" the number of n must be >=1 ");
		}
		if(n ==1)
		{
			System.out.println("mov disk " + n + " from " + fromTower + " to " +toTower);

		}
		else
		{
			moveDisk(n - 1, fromTower, auxTower, toTower);
			System.out.println("mov disk " + n + " from " + fromTower + " to " +toTower);
			moveDisk(n - 1, auxTower, toTower, fromTower);
		}
	}
}
