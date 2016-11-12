public class PriorityQueue 
{
	int size;
	int[] heap;
	int heap_size = 0;
	PriorityQueue(int[] a,int arr_size)
	{
		size = arr_size;
		heap = new int[size];
		for(int i = 0; i < a.length; ++i)
		{
			heap[i] = a[i];
			heap_size++;
		}
		for(int i = heap_size/2 - 1; i >= 0; i--)
			shiftDown(i);
	}
	PriorityQueue(int arr_size)
	{
		size = arr_size;
		heap = new int[size];
		
	}
	public int pop()
	{
		int max = heap[0];
		swap(0,--heap_size);
		shiftDown(0);
		return max;
	}
	public int top()
	{
		return heap[0];
	}
	public void heapSort()
	{

		while(heap_size > 0)
		{
			System.out.println(pop());
		}
		
	}
	public void insert(int key)
	{
		if(heap_size >= size)
		{
			return;
		}
		int k = heap_size;
		heap[heap_size] = key;
		heap_size++;
		while(heap[(k-1)/2] < heap[k])
		{
			
			swap((k-1)/2,k);
			k = (k-1)/2;
		}
	
	}
	public void shiftDown(int i)
	{
		int left_key,right_key;
		int left = 2 * i  + 1;
		int right = 2 * i + 2;
		int max_pos = left;
	
		if(left >= heap_size)
		{
			return;
		}
		if(right < heap_size)
		{
			left_key = heap[left];
			right_key = heap[right];
			if(right_key > left_key)
				max_pos = max_pos + 1;
		}
		
		if(heap[max_pos] > heap[i])
		{
			swap(i,max_pos);
			shiftDown(max_pos);
		}
	}
	public void swap(int i,int j)
	{
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
		
	}
	public void printAll()
	{
		for(int i = 0; i < heap_size; ++i)
		{
			System.out.print(heap[i]+ " ");
		}
		System.out.println();
	}
	/*public static void main(String[]args)
	{
		int[] arr = {2,1,2,1,2,1,2,1,2,1,2,1,8,3,2,7,8,9};
		PriorityQueue q = new PriorityQueue(arr.length);
		for(int i = 0; i < arr.length; ++i)
		{
			q.insert(arr[i]);
		}
		q.heapSort();
		
	}*/
}
