package hello_world;

interface ICanFight
{

	public void Fight();
}

interface ICanSwim
{
	 static final int a=10;
	  int b=10;
	public void Swim();
}
class Hero implements ICanFight, ICanSwim
{
	public void Fight(){System.out.println(this.b);};
	public void Swim(){};
}


public class Game {

	Game(int i)
	{
		System.out.println("Game with parameter constructor");
		
	}
	
	Game(){System.out.println("Game without parameter constructor");}
	public static void main(String args[])
	{
		new BoardGame(10);
		new BoardGame(1.0);
		
		new Hero().Fight();
	}
	
	
}

class BoardGame extends Game
{
	BoardGame(int i)
	{
		//super(i);
		System.out.println("Board Game");
		
	}

	public BoardGame(double j) {
		// TODO Auto-generated constructor stub
		System.out.println("Board Game double");
	}
	
}


