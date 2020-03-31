package question1;

import java.util.List;

public class BinarySearchTree {
	private Node root = null;

	/**
	 * 
	 * @param newNode
	 */
	void insert(Node newNode) 
	{ 
		this.root = insertRec(root, newNode); 
	} 

	/**
	 * 
	 * @param root
	 * @param newNode
	 * @return
	 */
	Node insertRec(Node root, Node newNode) { 
		if (root == null) { 
			root = newNode; 
			return root; 
		} 

		if (newNode.getKey() < root.getKey()) 
			root.setLeft(insertRec(root.getLeft(), newNode)); 
		else if (newNode.getKey() > root.getKey()) 
			root.setRight(insertRec(root.getRight(), newNode)); 
		return root; 
	}

	/**
	 * 
	 * @param key
	 */
	void deleteKey(int key) 
	{ 
		this.root = deleteRec(root, key); 
	}
	/**
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	Node deleteRec(Node root, Integer key) 
	{ 
		if (root == null)
			return root; 
		if (key < root.getKey()) 
			root.setLeft(deleteRec(root.getLeft(), key)); 
		else if (key > root.getKey()) 
			root.setRight(deleteRec(root.getRight(), key)); 
		else
		{  
			if (root.getLeft() == null) 
				return root.getRight(); 
			else if (root.getRight() == null) 
				return root.getLeft(); 
			root.setKey(minValue(root.getRight())); 

			root.setRight(deleteRec(root.getRight(), root.getKey())); 
		} 
		return root; 
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	int minValue(Node root) 
	{ 
		int minv = root.getKey(); 
		while (root.getClass() != null) 
		{ 
			minv = root.getLeft().getKey(); 
			root = root.getLeft(); 
		} 
		return minv; 
	} 

	/**
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	public Node search(Node root, Integer key) 
	{  
		if (root == null || root.getKey() == key) 
			return root;  
		if (root.getKey() > key) 
			return search(root.getLeft(), key);  
		return search(root.getRight(), key); 
	}

	/**
	 * 
	 * @param root
	 * @param inOrder
	 * @return
	 */
	List<Node> inorderRec(Node root, List<Node> inOrder) { 
		if (root != null) { 
			inorderRec(root.getLeft(), inOrder); 
			inOrder.add(root);
			inorderRec(root.getRight(), inOrder); 
		} 
		return inOrder;
	}

	public Node getRoot() {
		return root;
	}
}
