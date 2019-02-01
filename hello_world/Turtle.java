package hello_world;
import java.io.*;
import java.util.*;

public class Turtle 
{
	private String name;
	private Formatter f;
	public Turtle(String name, Formatter f)
	{
		this.name = name;
		this.f = f;
	}
	
	public void Move(int x, int y)
	{
		f.format("%s The Turtle is at (%d,%d)\n",name, x,y);
		
	}
	public static void main(String[] args)
	{
		PrintStream outAlias = System.out;
		Turtle tommy = new Turtle("Tommy", new Formatter(System.out));
		Turtle terry = new Turtle("Terry", new Formatter(outAlias));
		
		tommy.Move(0, 0);
		terry.Move(4, 8);
		tommy.Move(3, 4);
		terry.Move(2, 5);
		tommy.Move(3, 3);
		terry.Move(3, 3);
		
	}
	
}
