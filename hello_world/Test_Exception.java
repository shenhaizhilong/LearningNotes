package hello_world;

public class Test_Exception {
	public static void main(String[] args) {
/*		int c = myintdivide(2, 0);
		int d = myintdivide(20, 2);*/

		for (int i = 0; i < 2; i++) {
			System.out.print(i + " ");
			try
			{
				System.out.println( 1/0);
				
			}
			catch( Exception ex)
			{
				/*System.out.println(" 222 the value of divisor can't be zero");*/
				System.out.println(ex);
			}
			
		}
	}

	public static int myintdivide(int a, int b) {
		if (b == 0) {
			System.out.println(" the value of divisor can't be zero");
			System.exit(1);
		}
		return a / b;

	}

}
