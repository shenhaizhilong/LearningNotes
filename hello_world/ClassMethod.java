package hello_world;

interface HasBatteries{}
interface WaterProof{}
interface Shoots {}

class Toy
{
	Toy(){}
	Toy(int i){}
	
}

class FancyToy extends Toy implements HasBatteries, WaterProof, Shoots
{
	FancyToy() {super(1);}
}


public class ClassMethod 
{
	public static void main(String[] args)
	{
		Class cc = null;
		try
		{
			cc = Class.forName("hello_world.FancyToy");
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("can't find the class");
			System.exit(1);
			
		}
		
		PrintInfo(cc);
		for(Class face : cc.getInterfaces())
		{
			PrintInfo(face);
		}
		
		Class up = cc.getSuperclass();
		Object obj = null;
		try
		{
			obj = up.newInstance();
		}
		catch(InstantiationException e)
		{
			System.out.println("can't instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("can't access");
			e.printStackTrace();
			System.exit(1);
		}
		
		PrintInfo(obj.getClass());
	}
	static void PrintInfo(Class cc)
	{
		System.out.println("Class Name:" + cc.getName() + " is interface? [" + cc.isInterface() +"]");
		System.out.println("Simple Name:" + cc.getSimpleName());
		System.out.println("Canonical Name:" + cc.getCanonicalName());
		
	}
}


