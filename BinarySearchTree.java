class BinarySearchTree
{
	Node root;
	int size = 0;
	class Node
	{
		Node left;
		Node right;
		long key;
		Node(long _val)
		{
			key = _val;
		}
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
	public void insert(long key)
	{
		root = insertRec(root,key);
	}
	public Node insertRec(Node root ,long key)
	{
		if(root == null)
		{
			size++;
			return new Node(key);
		}
		if(root.key == key)
			return root;
		if(key > root.key)
			root.right = insertRec(root.right,key);
		else
			root.left = insertRec(root.left,key);
		return root;
	}
	public void remove(int key)
	{
		root = removeRec(root,key);
	}
	public Node removeRec(Node root,long key)
	{
		if(key > root.key)
			root.right = removeRec(root.right,key);
		else if(key < root.key)
			root.left = removeRec(root.left,key);
		else
		{
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else
			{
				root.key = getMinValue(root.right).key;
				root.right = removeRec(root.right,root.key);
			}
		}
		return root;
	}
	public Node getMinValue(Node node)
	{
		Node current = node;
		if(current.left == null)
			return current;
		return getMinValue(current.left);
		
			
	}
	public void inorder()
	{
		inorder_traversal(root);
	}
	private void inorder_traversal(Node focusNode)
	{
		if(focusNode == null)
			return; 
		inorder_traversal(focusNode.left);
		System.out.println(focusNode.key);
		inorder_traversal(focusNode.right);
	}
}
