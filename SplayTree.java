class SplayTree
{
	Node root;
	class Node
	{
		Node left;
		Node right;
		int key;
		Node(int _key)
		{
			key = _key;
		}
	}
	public Node leftRotate(Node root)
	{
		Node x = root;
		Node y = root.right;
		
		x.right = y.left;
		y.left = x;
		
		
		return y;
	}
	public Node rightRotate(Node root)
	{
		Node x = root;
		Node y = x.left;
		
		x.left = y.right;
		y.right = x;
		
		return y;
	}
	private Node splay(Node root,int key)
	{
		//found || node doesn't exist
		if(root == null || key == root.key)
			return root;
		
		//check if case : zig
		if(key < root.key)
		{
			//key doesn't exist in tree
			if(root.left == null)
				return root;
			//zig zig
			if(key < root.left.key)
			{
				root.left.left = splay(root.left.left,key);
				root = rightRotate(root);
			}
			//zig zag
			else if(key > root.left.key)
			{
				root.left.right = splay(root.left.right,key);
				if(root.left.right != null)
					root.left = leftRotate(root.left);
			}
			return root.left == (null) ? root : rightRotate(root);
		}
		else
		{
			//not exist
			if(root.right == null)
				return root;
			//zag zag
			if(key > root.right.key)
			{
				root.right.right = splay(root.right.right,key);
				root = leftRotate(root);
			}
			//zag zig
			else if(key < root.right.key)
			{
				root.right.left = splay(root.right.left,key);
				if(root.right.left != null)
					root.right = rightRotate(root.right);
			}
			return root.right == (null) ? root : leftRotate(root);
		}
		
	}
	public boolean search(int key)
	{
		root = splay(root,key);
		if(root == null)
			return false;
		if(key == root.key)
		{
			return true;
		}
		return false;
	}
	public void insert(int key)
	{
		Node newNode = new Node(key);
		if(root == null)
		{
			root = newNode;
			return ;
		}
		root = splay(root,key);
		
		if(key == root.key)
			return;
		else if(key < root.key)
		{
			newNode.right = root;
			newNode.left = root.left;
			root.left = null;
		}
		else
		{
			newNode.left = root;
			newNode.right = root.right;
			root.right = null;
		}
		
		root = newNode;
		
	}
	public boolean delete(int key)
	{
		root = splay(root,key);
		if(root == null)
			return false;
		else if(key == root.key)
		{
			if(root.left == null)
				root = root.right;
			else
			{
				Node x = root;
				root = splay(root.left,key);
				root.right = x.right;
			}
			return true;
		}
		return false;
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
