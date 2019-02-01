package hello_world;

public class Faculty extends Employee 
{
	public static void main(String[] args)
	{
		Faculty F= new Faculty();
		
	}
	
	public Faculty()
	{
		System.out.println(" 4 performs Faculty's tasks");
		super.Print();
	}
	
	
}

class Employee extends Person
{
	public Employee()
	{
		this(" 2 Invoke Employee's overload constructor");
		System.out.println(" 3 performs Employee's tasks ");
	}
	
	public Employee(String s)
	{
		System.out.println(s);
		
	}
	public static void Print()
	{
		System.out.println(" Invoke parent class method");
		
	}
}

class Person 
{
	public Person()
	{
		System.out.println(" 1 performs Person's tasks");
	}

}
