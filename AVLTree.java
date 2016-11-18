class AVLTree
{
	Node root;
	int size = 0;
	class Node
	{
		Node left;
		Node right;
		long key;
		int height = 0;
		Node(long _key)
		{
			key = _key;
		}
	}
	public int getHeight(Node root)
	{
		if(root == null)
			return -1;
		return root.height;
	}
	public Node leftRotate(Node root)
	{
		Node x = root;
		Node y = root.right;
		
		x.right = y.left;
		y.left = x;
		
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		
		return y;
	}
	public Node rightRotate(Node root)
	{
		Node x = root;
		Node y = x.left;
		
		x.left = y.right;
		y.right = x;
		
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		
		return y;
	}
	private int getBalance(Node root)
	{
		return getHeight(root.left) - getHeight(root.right);
	}
	public void insert(long key)
	{
		root = insertRec(root,key);
	}
	public Node insertRec(Node root,long key)
	{
		if(root == null)
			return new Node(key);
		else if(key == root.key)
			return root;
		else if(key > root.key)
			root.right = insertRec(root.right,key);
		else
			root.left = insertRec(root.left,key);
		
		root.height = Math.max(getHeight(root.right),getHeight(root.left)) + 1;
		int balance = getBalance(root);
		
		
		if(balance < -1 && key > root.right.key)
			return leftRotate(root);
		if(balance < -1 && key < root.right.key)
		{
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		if(balance > 1 && key < root.left.key)
			return rightRotate(root);
		if(balance > 1 && key > root.left.key)
		{
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		return root;
		
	}
	public void delete(long key)
	{
		root = deleteRec(root,key);
	}
	public Node deleteRec(Node root,long key)
	{
		if(root == null)
		{
			return root;
		}
		else if(key > root.key)
		{
			root.right = deleteRec(root.right,key);
		}
		else if(key < root.key)
		{
			root.left = deleteRec(root.left,key);
		}
		else
		{
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else
			{
				long successor = getMin(root.right).key;
				root.key = successor;
				root.right = deleteRec(root.right,successor);
			}
		}
		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		int balance = getBalance(root);
		if(balance < -1 && getBalance(root.right) <= 0)
			return leftRotate(root);
		if(balance < -1 && getBalance(root.right) > 0)
		{
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		if(balance > 1 && getBalance(root.left) >= 0)
			return rightRotate(root);
		if(balance > 1 && getBalance(root.left) < 0)
		{
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		return root;
	}
	public Node getMin(Node root)
	{
		if(root.left == null)
			return root;
		return getMin(root.left);
		
	}
	public boolean search(Node root,long key)
	{
		if(root == null)
			return false;
		
		else if(key > root.key)
			return search(root.right,key);
		else if(key < root.key)
			return search(root.left,key);
		else
			return true;
	}
	public void display()
	{
		inorder(root);
	}
	public void inorder(Node root)
	{
		if(root == null)
			return ;
		inorder(root.left);
		System.out.println(root.key);
		inorder(root.right);
	}
	
}
