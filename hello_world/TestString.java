package hello_world;

public class TestString
{
	public static void main(String[] args)
	{
		String a = "hello,";
		StringBuffer b = new StringBuffer("hey,");
		b.append(a);
		
		StringBuilder sb = new StringBuilder(a);
		sb.append(a);
		sb.append(b);
		sb.reverse();
		sb.append(10);

		System.out.println(a);
		System.out.println(b);
		System.out.println(sb);
		sb.delete(0, 2);
		System.out.println(sb);
		
		sb.delete(0,sb.length());
		System.out.println(sb);
		
		
	}

}
