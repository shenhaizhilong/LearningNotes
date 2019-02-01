package hello_world;

public class TestPriorityQueue 
{
	public static void main(String[] args)
	{
		Patient pa1 = new Patient("tom", 10);
		Patient pa2 = new Patient("xiaoming", 12);
		Patient p3 = new Patient("xiaozhang", -20);
		Patient p4 = new Patient("xiaohong", 0);
		MyPriorityQueue<Patient> pri_queue = new MyPriorityQueue<Patient>();
		pri_queue.enqueue(pa1);
		pri_queue.enqueue(pa2);
		pri_queue.enqueue(p3);
		pri_queue.enqueue(p4);
		
		while(pri_queue.getsize() > 0)
		{
			System.out.println(pri_queue.dequeue());
		}
		
	}
	
	public static class Patient implements Comparable<Object>
	{
		private String name;
		private int priority;
		public Patient(String name, int priority)
		{
			this.name = name;
			this.priority = priority;
			
		}
		
		public String toString()
		{
			return name + "(Priority:" + priority + ")"; 
		}
		public int compareTo(Object o)
		{
			return this.priority - ((Patient) o).priority;
		}
	}

}
