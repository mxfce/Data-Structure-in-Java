class InsertionSort
{
	
	public static void sort(int[] arr)
	{
		for(int i = 1; i < arr.length; ++i)
		{
			int j = i ;
			int current = arr[i];
			while(j > 0 && current < arr[j - 1])
			{
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = current;	
		}
	}
	public static void swap(int[] arr,int i,int j)
	{
	    int tmp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = tmp;
	}
}
