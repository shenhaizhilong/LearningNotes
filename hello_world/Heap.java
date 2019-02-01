package hello_world;
import java.util.ArrayList;
public class Heap<E extends Comparable> 
{
	/*public static void main(String[] args)
	{
		
	}*/
	
	private ArrayList<E> list = new ArrayList<E>();
	
	// create a default heap
	public Heap(){}
	
	// create a heap from a list
	public Heap(E[] objects)
	{
		for(int i = 0; i < objects.length; i++)
		{
			list.add(objects[i]);
		}
	}
	
	//return the size of heap
	public int getsize()
	{
		return list.size();
	}
	
	public void add(E newobject)
	{
		list.add(newobject);
		int currentindex= list.size() - 1;
		while(currentindex > 0)
		{
			int parentindex = (currentindex - 1) / 2;
			// swap the element if the current element is greater than parent element
			if(list.get(parentindex).compareTo(list.get(currentindex)) < 0)
			{
				E tmp = list.get(currentindex);
				list.set(currentindex, list.get(parentindex));
				list.set(parentindex, tmp);
			}
			else
			{
				
				break; // the tree is heap now
			}
				
			currentindex = parentindex;
		}
	}
	
	// remove the root from the heap
	public E remove()
	{
		if(list.size() == 0){return null;}
		
		E removeobject = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() -1);
		int currentindex = 0;
		while(currentindex < list.size())
		{
			int leftindex = 2 * currentindex + 1;
			int rightindex = 2 * (currentindex + 1);
			if(leftindex >= list.size()){ break;}  //the tree is heap now
			
			// find the max value between the two children
			int maxindex = leftindex;
			if(rightindex < list.size() && list.get(maxindex).compareTo(list.get(rightindex)) < 0)
			{
					maxindex = rightindex;
				
			}
			//if the current root is less than the maximum, swap their value
			if(list.get(currentindex).compareTo(list.get(maxindex)) < 0)
			{
				E tmp = list.get(currentindex);
				list.set(currentindex, list.get(maxindex));
				list.set(maxindex, tmp);
				currentindex = maxindex;
			}
			else
			{
				break;
			}
			
			
		}
		
		
		return removeobject;
		
		
	}
	
}
