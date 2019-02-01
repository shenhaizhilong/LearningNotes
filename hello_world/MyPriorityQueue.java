package hello_world;

public class MyPriorityQueue<E extends Comparable>
{

	private  Heap<E> heap = new Heap<E>();
	
	// add a new object to the heap
	public  void enqueue(E newobject)
	{
		heap.add(newobject);
	}
	
	// remove the root object from the heap
	public E dequeue()
	{
		return heap.remove();
	}
	
	public int getsize()
	{
		return heap.getsize();
	}
	
	
	
}


