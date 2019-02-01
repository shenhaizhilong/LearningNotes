package hello_world;

public class TestEdible 
{
	public static void main(String[] args)
	{
		Object[] objects = {new Tiger(), new Apple(), new Orange()};
		for( int i = 0; i < objects.length; i++)
		{
			if( objects[i] instanceof Edible)
			{
				System.out.println(((Edible)objects[i]).howToEat());
				System.out.println(((Edible)objects[i]).i);
				System.out.println(Edible.i);
			}
			if(objects[i] instanceof Animal)
			{
				System.out.println(((Animal)objects[i]).sound());
			}
		}
		
/*		Edible a = null;
		a.howToEat();
		*/
		
		
	}
	
}

abstract class Animal
{
	
 /* return animal sound */
	public abstract  String sound();
}

 interface Edible 
{
	int i =10;
	public abstract String howToEat();
	// String howToEat();  //
}
 
 interface AB
 {
	 void print();;
 }
 
 
 interface AC
 {
	 void print();;
 }
 
 class BB  implements AB
 {
	 public void print()
	 {
		 System.out.println("hello, world!");
	 }
 }

 abstract interface D extends AB,AC
 {
	 abstract void print();
 }
 
 
 
/* public abstract interface B
 {
  // The public type B must be defined in its own file
	 void print();
 }*/
 
class Checken extends Animal implements Edible
{
	@Override
	public String howToEat()
	{
		return " Chiek : Fry it";
	}
	
	@Override
	public String sound()
	{
		return " Checken: jiji";
	}

}

class Tiger extends Animal
{

/*	@Override
	public String sound() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	@Override
	public String sound()
	{
		return "Tiger: ao" ;
		
	}
}

abstract class Fruit implements Edible
{
	
	// data fields
}


class Apple extends Fruit
{

	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return " Apple: make apple cider" ;
	}

	private int weight = 0;
	private String color = "";

	public Apple()
	{

	}
	public Apple(int weight)
	{
		this.weight = weight;
	}
	public Apple(int weight, String color){
		this.weight = weight;
		this.color = color;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return "Apple{" +
				"color='" + color + '\'' +
				", weight=" + weight +
				'}';
	}
	
}

class Orange extends Fruit
{

	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return "Orange: Make Orange juice";
	}
	
}