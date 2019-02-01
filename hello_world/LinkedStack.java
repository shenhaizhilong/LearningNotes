package hello_world;

public class LinkedStack<T>
{

	private static class Node<U> 
	{
		U item;
		Node<U> next;
		Node(){item = null; next = null;}
		Node(U item, Node<U> next)
		{
			this.item = item;
			this.next = next;
		}
		boolean end(){return item ==null && next ==null;}	
	}
	private Node<T> top = new Node<T>(); //End sentinel 
	public void push(T item)
	{
		top = new Node(item, top);
	}
	public T pop()
	{
		T result = top.item;
		if(!top.end())
		{
			top = top.next;
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		LinkedStack<Integer> lsI = new LinkedStack<Integer>();
		for(int i=0; i < 10; i++)
		{
			lsI.push(i);
		}
		Integer i ;
		while((i = lsI.pop()) !=null)
		{
			System.out.println(i);
		}
	}
}
