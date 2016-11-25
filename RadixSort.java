class RadixSort
{
	int[] a;
	int max = Integer.MIN_VALUE;
	ArrayList<Integer>[] bucket = new ArrayList[10];
	RadixSort(int[] _a)
	{
		a = _a;
		for(int i = 0; i < 10; ++i)
		{
			bucket[i] = new ArrayList<Integer>();
		}
		
	}
	public void find_max()
	{
		for(int i = 0; i < a.length; ++i)
			max = Math.max(max, a[i]);
	}
	public void bucket()
	{
		int []digit = new int[10];
		int mul = 1;
		while(max > 0)
		{
			for(int i = 0; i < a.length; ++i)
			{
				bucket[(a[i]/mul) % 10].add(a[i]);
			}
			int k = 0;
			for(int i = 0; i < 10; ++i)
			{
				for(int j = 0; j < bucket[i].size(); ++j)
				{
					a[k++] = bucket[i].get(j);
				}
				bucket[i].clear();
			}
			System.out.println(Arrays.toString(a));
			mul *= 10;
			max /= 10;
		}
	}
	
}
