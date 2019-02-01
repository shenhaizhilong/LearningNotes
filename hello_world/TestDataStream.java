package hello_world;
import java.io.*;

public class TestDataStream
{

	public static void main(String[] args) throws IOException
	{
		try
		(
				//create an data output steam to a file
				DataOutputStream output = new DataOutputStream(new FileOutputStream("data.txt"));
				
		)	
		{
			
			output.writeInt(100);
			output.writeUTF("ddddddddddddddd10222¹þ¹þ¹þ\n");
			output.writeUTF("hhh\n");
			output.writeUTF("10\n");
		}
		
		try(
				// create an input steam to a file
				DataInputStream input = new DataInputStream(new FileInputStream("data.txt"));
			){
			System.out.println(input.readInt());
			System.out.println(input.readUTF());
			System.out.println(input.readUTF());
			System.out.println(input.readUTF());
			
		}
			
			
		}
}
