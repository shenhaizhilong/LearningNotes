package hello_world;
import java.io.*;
public class TestFileStream
{
	public static void main(String[] args) throws IOException
	{
		try
		(
				//create an output steam to a file
				FileOutputStream output = new FileOutputStream("temp.dat");
		)	
		{
			for(int i =0; i < 1000; i++)
			{
				//write an byte 
				output.write(i);
				
			}
		}
		
		try(
				// create an input steam to a file
				FileInputStream input = new FileInputStream("temp.dat");
			){
			int value;
			// read a byte
			while((value = input.read()) != -1)
			{
				System.out.print(value +" ");
			}
			
		}
		
		try
		(
				//create an output steam to a file
				FileOutputStream output2 = new FileOutputStream("temp.txt", true);
				PrintWriter pw =  new PrintWriter(output2);
		)	
		{
			for(int i =0; i < 1000; i++)
			{
				 
				pw.println(i);
				pw.write(i);
				
				
			}
		}
		
		
	}
	
}
