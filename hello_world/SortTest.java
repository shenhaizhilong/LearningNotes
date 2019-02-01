package hello_world;

public class SortTest
{

	public static void main(String[] args)
	{
		int[] a= {1,4,2,9,100,3,33,45,200,1,2,3,5,6,4,3,2,22,1,90};
		Integer[] b = {1,4,2,9,100,3,33,45,200,1,2,3,5,6,4,3,2,22,1,90};
		String[] bd = {"1d","dd","2d3","9d","100d","9d0"};
		// test BubbleSort
		// BubbleSort(a);
		// test MergeSort
		// MergeSort(a);
		//test quick sort
		// QuickSort(a,0,a.length - 1);
		// test heap sort
		HeapSort(b);
		for( int i =0; i < b.length; i++)
		{
			System.out.print(b[i] + " ,");
		}
		
		System.out.println("");
		
		HeapSort(bd);
		for( int i =0; i < bd.length; i++)
		{
			System.out.print(bd[i] + " ,");
		}
		
		
	}
	
	public static void BubbleSort(int[] list)
	{
		boolean nestpass = true;
		int k = list.length;
		int temp;
		for(int i = 1; i < k && nestpass; i++)
		{
			nestpass = false;
			for( int j = 0; j < k - i;j++)
			{
				if(list[j] > list[j+1])
				{
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					nestpass = true;
				}
			}
		}
		
	}
	
	// merge sort part
	
	public static void MergeSort(int[] list)
	{
		if( list.length > 1)
		{
			int[] firsthalf = new int[list.length/2];
			int secondhalflength=list.length - list.length/2;
			int[] secondhalf= new int[secondhalflength];
			System.arraycopy(list, 0, firsthalf, 0, list.length/2);
			System.arraycopy(list, list.length/2, secondhalf, 0, secondhalflength);
			MergeSort(firsthalf);
			MergeSort(secondhalf);
			int[] tmp = Merge(firsthalf,secondhalf);
			System.arraycopy(tmp, 0, list, 0, tmp.length);
			
		}
		
	}
	
	
	//merge two sorted list
	private static int[] Merge(int[] a, int[] b)
	{
		int[] tmp = new int[a.length + b.length];
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;
		
		while(current1 < a.length && current2 < b.length)
		{
			if(a[current1] > b[current2])
			{
				tmp[current3++] = b[current2++];
				
			}
			else
			{
				tmp[current3++] = a[current1++];
			}
		}
		
		while(current1 < a.length)
			tmp[current3++] = a[current1++];
		while(current2 < b.length)
			tmp[current3++] = b[current2++];
		
		
		return tmp;
		
	}
	
	
	// Quick sort part
	public static void QuickSort(int[] list, int first, int last)
	{
		if(last > first)
		{
			int pivotindex = Partition(list, first, last);
			//quick sort the left part where all the elements less  than pivot
			QuickSort(list,first, pivotindex -1);
			//quick sort the right part where all the elements greater than pivot 
			QuickSort(list, pivotindex +1, last);
		}
		
	}
	private static int Partition(int[] list, int first, int last)
	{
		int pivot = list[first]; // chose the first element as the pivot
		int low = first + 1;
		int high = last;
		int tmp = 0;
		
		
		while(high > low)
		{
			while(low <= high && list[low] <= pivot)
				low++;
			while(low <= high && list[high] > pivot)
				high--;
			// swap the two element in the list
			if(high > low)
			{
				tmp = list[low];
				list[low] = list[high];
				list[high] = tmp;
			}
		}
		
		while(high > first && list[high] >= pivot)
			high--;
	// swap pivot with the list[high]
		if( pivot > list[high])
		{
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else
			return first;
	}
	
	public static   <E extends Comparable<?>> void HeapSort(E[] list)
	{
		
		// Cannot make a static reference to the non-static method HeapSort(Integer[]) from the type SortTest
		// create a heap of E
		Heap<E> heap = new Heap<E>();
		for(int i = 0; i < list.length; i++)
		{
			heap.add(list[i]);
			
		}
		//remove elements from the heap
		for(int i = list.length - 1; i >= 0; i--)
		{
			list[i] = heap.remove();
		}
		
	}
	
}
