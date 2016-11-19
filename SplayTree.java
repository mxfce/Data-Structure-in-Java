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
	public Node splay(Node root,int key)
	{
		if(root == null || key == root.key)
			return root;
		
		if(key < root.key)
		{
			//key doesn't exist in tree
			if(root.left == null)
				return root;
			// zig
			if(key < root.left.key)
			{
				root.left.left = splay(root.left.left,key);
				root = rightRotate(root);
			}
			//zag
			else if(key > root.left.key)
			{
				root.left.right = splay(root.left.right,key);
				if(root.left.right != null)
					root.left = leftRotate(root.left);
			}
			//zig
			return root.left == null ? root : rightRotate(root);
		}
		else
		{
			//key doesn't exist in tree
			if(root.right == null)
				return root;
			//zag
			if(key > root.right.key)
			{
				root.right.right = splay(root.right.right,key);
				root = leftRotate(root);
			}
			//zig
			else if(key < root.right.key)
			{
				root.right.left = splay(root.right.left,key);
				root.right = rightRotate(root.right);
			}
			//zag
			return root.right == null ? root : leftRotate(root);
		}
		
	}
	public void insert(int key)
	{
		if(root == null)
			root = new Node(key);
		else
		{
			root = splay(root,key);
			if(key < root.key)
			{
				Node x = root;
				root = new Node(key);
				root.right = x;
				root.left = x.left;
				x.left = null;
			}
			else if(key > root.key)
			{
				Node x = root;
				root = new Node(key);
				root.left = x;
				root.right = x.right;
				x.right = null;
			}
		}
	}
	public boolean search(int key)
	{
		root = splay(root,key);
		if(key == root.key)
			return true;
		return false;
	}
	public boolean delete(int key)
	{
		root = splay(root,key);
		if(root == null)
			return false;
		else if(key == root.key)
		{
			if(root.left == null)
			{
				root = root.right;
			}
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
	
	//helper function
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
	public void inorder(Node root)
	{
		if(root == null)
			return ;
		inorder(root.left);
		System.out.println(root.key);
		inorder(root.right);
	}
}
