class QuickSort
{
	int[] a;
	QuickSort(int[] _a)
	{
		a = _a;
		
	}
	public void quick_sort()
	{
		partition(0,a.length-1);
	}
	public void partition(int left,int right)
	{
		
		if(left < right)
		{
			int pivot = pivot_sort(left,right);
			partition(left,pivot - 1);
			partition(pivot + 1 , right);
		}
	}
	public int pivot_sort(int left,int right)
	{
		int wall = left + 1;
		int pivot = a[left];
		for(int i = left + 1; i <= right; ++i)
		{
			if(pivot > a[i])
			{
				swap(wall,i);
				wall++;
			}
		}
		swap(left,wall - 1);
		return wall - 1;
	}
	public void swap(int i,int j)
	{
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
