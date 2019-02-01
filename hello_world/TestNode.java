package hello_world;

public class TestNode 
{

	public static void main(String[] args)
	{
		Node<String> head = null;
		Node<String> tail = null;
		head = new Node<String>("David");
		tail = head;
		tail.next = new Node<String>("Fenix");
		tail = tail.next;
		tail.next = new Node<String>("XiaoZhang");
		tail = tail.next;
		NodePrint( head);
		
	}
	
	public static <E> void NodePrint(Node<E> head)
	{
		Node<E> current = head;
		while(current != null)
		{
			System.out.println(current.element);
			current = current.next;
		}
	}
}
