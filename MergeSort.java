class MergeSort
{
	int[] a;
	MergeSort(int[] _a)
	{
		a = _a;
	}
	public void merge_sort()
	{
		partition(0,a.length-1);
	}
	public void partition(int left,int right)
	{
		
		if(left < right)
		{
			int mid = (left + right) / 2;
			partition(left,mid);
			partition(mid + 1 , right);
			merge(left,mid,right);
		}
	}
	public void merge(int left,int mid,int right)
	{
		int p = left;
		int q = mid + 1;
		int []b = new int[right - left + 1];
		int k = 0;
		for(int i = left; i <= right; ++i)
		{
			if(p > mid)
			{
				b[k++] = a[q++];
			}
			else if(q > right)
			{
				b[k++] = a[p++];
			}
			else if(a[p] > a[q])
			{
				b[k++] = a[q++];
			}
			else
				b[k++] = a[p++];
		}
		for(int i = 0; i < k; ++i)
		{
			a[left++] = b[i];
		}
	}
}
