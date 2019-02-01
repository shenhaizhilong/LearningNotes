package hello_world;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Test_File2 
{
	
	public static void main(String[] args) throws FileNotFoundException
	{

		String filename = "E:\\extract_vm_info\\a.txt";
		File myfile = new File(filename);
		if( !myfile.exists())
		{
			System.out.println(" the file " + myfile.getName() +" doesn't exist" );
			System.exit(1);
		}
		
		try (PrintWriter outwriter = new PrintWriter(myfile);)
		{
			for( int i = 0; i < 1000; i++)
			{
				outwriter.println(" the value is :" + i);
			}
		}

		
		
		
	}
	

}
