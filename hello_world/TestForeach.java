package hello_world;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestForeach
{
	public static void main(String[] args) throws InterruptedException
	{
		StringBuilder sbuilder = new StringBuilder("hello,stringbuilder");
		int[] aArray = {1,2,3,3,4,5,6,7};
		for(int a : aArray)
		{
			sbuilder.append(a);
			System.out.println(sbuilder.toString());
		}

		StringBuffer stringBuffer = new StringBuffer("Tom");
        System.out.println(stringBuffer);




	}

}
