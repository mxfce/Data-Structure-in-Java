class LinearHashTable
{
	int[] table;
	int elementInArray;
	int size;
	LinearHashTable(int _size)
	{
		size = _size;
		table = new int[size];
		Arrays.fill(table, -1);
	}
	public void insert(int key)
	{
		int hashVal = key % size;
		int i = hashVal;
		while(table[i] != -1)
		{
			i++;
			i %= size;
		}
		table[i] = key;
	}
	public boolean search(int key)
	{
		int hash_val = key % size;
		int i = hash_val;
		int cnt = 0;
		while(true)
		{
			if(cnt >= size)
				return false;
			if(table[i] == 0)
				return false;
			else if(table[i] == key)
				return true;
			cnt++;
			i++;
			i %= size;
		}
	}
	public boolean delete(int key)
	{
		int hash_val = key % size;
		int i = hash_val;
		int cnt = 0;
		while(true)
		{
			if(cnt >= size)
				return false;
			if(table[i] == 0)
				return false;
			else if(table[i] == key)
			{
				table[i] = -1;
				return true;
			}
			cnt++;
			i++;
			i %= size;
		}
	}
