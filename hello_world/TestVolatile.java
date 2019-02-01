package hello_world;


public class TestVolatile implements Runnable 
{

	private volatile boolean status;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		status = true;
		while(status)
		{
			for(int i = 0; i < 10; i++)
			{
				System.out.println(10);
			}
			
			this.stop();
		}
	}

	public void stop()
	{
		status = false;
	}
	
	public static void main(String[] args)
	{
		
		Integer bInteger = 10;
		
	
		TestVolatile a = new TestVolatile();
		a.run();
		a.stop();
		System.out.println(bInteger);
	}

	
}
