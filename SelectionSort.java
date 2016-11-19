class SelectionSort
{
	public static void sort(int[] arr)
	{
		for(int i = arr.length - 1; i >= 0; --i)
		{
			int max = Integer.MIN_VALUE;
			int maxpos = 0;
			for(int j = 0; j <= i; ++j)
			{
				if(arr[j] > max)
				{
					max = arr[j];
					maxpos = j;
				}
			}
			swap(arr,maxpos,i);
		}
	}
	public static void swap(int[] arr,int i,int j)
	{
	    int tmp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = tmp;
	}
}
