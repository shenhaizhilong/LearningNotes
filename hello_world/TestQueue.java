package hello_world;
import java.util.*;


public class TestQueue {

	public static void main(String[] args)
	{
		Queue<String> queue1 = new LinkedList<String>();
		// Queue<String> queue2 = new Queue<String>();
		queue1.offer("Beijing");
		queue1.offer("Nanjing");
		queue1.offer("Nanjing");
		queue1.offer("Dongjing");
		queue1.offer("Xi An");
		queue1.offer("Tian Jing");
		System.out.println(queue1);
		for(String item: queue1)
		{
			if(item.startsWith("N"))
				System.out.println(item);
		}
		
		//Queue<String> queue2 = new Queue<String>();
		PriorityQueue<String> queue3 = new PriorityQueue<String>();
		Queue<String> queue4 = new LinkedList<String>();
//		Deque<String> deque1 = new LinkedList<String>(queue1);
//		System.out.println(deque1);
//		System.out.printf("%s,%s,%s,%s", deque1.getFirst(),deque1.getLast(),deque1.removeLast(),deque1.getLast());
//		while(!deque1.isEmpty())
//		{
//			System.out.printf("%s,",deque1.removeFirst());
//		}
//
//
//		System.out.printf("output deque1: %s",deque1);
	}
}
