class DoubleHashTable
{
	int[] table;
	int elementInArray;
	int size;
	DoubleHashTable(int _size)
	{
		size = _size;
		table = new int[size];
		Arrays.fill(table, -1);
	}
	public void insert(int key)
	{
		int hashVal = key % size;
		int i = hashVal;
		int cnt = 0;
		double eq = 3 - (key % 3 ) ;
		while(table[i] != -1)
		{
			if(cnt > size)
				return ;
			i += eq;
			i %= size;
			cnt++;
		}
		table[i] = key;
	}
	public boolean search(int key)
	{
		int hash_val = key % size;
		int i = hash_val;
		double eq = 3 - (key % 3 ) ;
		int cnt = 0;
		while(true)
		{
			if(cnt > size)
				return false;
			if(table[i] == 0)
				return false;
			else if(table[i] == key)
				return true;
			i += eq;
			i %= size;
			cnt++;
		}
	}
	public boolean delete(int key)
	{
		int hash_val = key % size;
		int i = hash_val;
		double eq = 3 - (key % 3 ) ;
		int cnt = 0;
		while(true)
		{
			if(cnt > size)
				return false;
			if(table[i] == 0)
				return false;
			else if(table[i] == key)
			{
				table[i] = -1;
				return true;
			}
			i += eq;
			i %= size;
			cnt++;
		}
	}
}
