class QuadraticHashTable
{
	int[] table;
	int elementInArray;
	int size;
	QuadraticHashTable(int _size)
	{
		size = _size;
		table = new int[size];
		Arrays.fill(table, -1);
	}
	public void insert(int key)
	{
		int hashVal = key % size;
		int i = hashVal;
		int k = 1;
		while(table[i] != -1)
		{
			if(k > size)
				return ;
			i = hashVal + k*k;
			i %= size;
			k++;
		}
		table[i] = key;
	}
	public boolean search(int key)
	{
		int hash_val = key % size;
		int i = hash_val;
		
		int k = 1;
		while(true)
		{
			if(k > size)
				return false;
			if(table[i] == 0)
				return false;
			else if(table[i] == key)
				return true;
			i = hash_val + k*k;
			i %= size;
			k++;
		}
	}
	public boolean delete(int key)
	{
		int hash_val = key % size;
		int i = hash_val;
		
		int k = 1;
		while(true)
		{
			if(k > size)
				return false;
			if(table[i] == 0)
				return false;
			else if(table[i] == key)
			{
				table[i] = -1;
				return true;
			}
			i = hash_val + k*k;
			i %= size;
			k++;
		}
	}
}
