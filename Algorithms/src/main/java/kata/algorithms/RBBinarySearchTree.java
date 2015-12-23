package kata.algorithms;


/**
* Based on Wikipedia:
* Red-black tree is a kind of 'self-balancing binary search tree'
* Each node has an extra bit, and that bit is often interpreted as the color (red or black)
* of the node. The color bits are used to ensure that the tree remains approximately balanced 
* during insertions and deletions
*
* Leaf nodes of rb trees don't contain any data. Normally held by a null pointer.
* 
* Requirements for Binary Search Tree
* 	1. Each node in the tree stores an element and can have at most two child nodes.
*	2. The tree does not contain any duplicate values.
*	3. Elements in a node's left subtree are strictly smaller than the node's element.
*	4. Elements in a node's right subtree are strictly greater than the node's element.
*
* Requirements for Red-Black Tree:
* 	1. A node is either red or black
*	2. The root is black. This rule is sometimes omitted. Since the root can always be changed from red
* 		to black, but not necissarily vice versa.
*	3. All leaves (NULL) are considered black.
*	4. If a node is red, then both its children are black.
*	5. Every path from a given node to any of its decendant NULL nodes contains the same number of black nodes.
*		The uniform number of black nodes in paths from root to leaves is called the 'black-height' of the red-black tree.
*
*
* ::Algorithm Complexity:::: AC = Average case :: WC = worst case
* Space		AC: O(n)		WC: O(n)		
* Search 	AC: O(log n)	WC: O(log n)
* Insert 	AC: O(log n)	WC: O(log n)
* Delete 	AC: O(log n)	WC: O(log n)
*
* TODO: BST Print the neighbor of each element in a tree
*
*				10
* 			   /  \
*			  7	   29
*			/  \  /  \
*		   5   9 11   35
* 
*
*		Example: 10-> Null 	| 	7->29	| 5-> 9 | 9 -> 11 | 11 -> 35
*
*	TODO: Lowest Common ancestor in a Bianry Search Tree and Binary Tree.
* 	TODO: Vertical traversal of a Binary Tree.
*	TODO: Convert BST into DLL and vice versa in place
* 	TODO: Binary tree traversal questions like left view, right view, top view, bottom view, maximum of a level, minimum of a level, children sum property, diameter etc.
*/

public class RBBinarySearchTree {
	private Node<Integer, Integer> root;
	private int size = 0;

	public int getSize() {
		return size;
	}

	public void insertAll(int[] values) {
		for(int i = 0; i < values.length; i++) {
			insert(values[i]);
		}
	}

	public void insert(int value) {
		if (root == null) {
			root = new Node<Integer, Integer>(value);
		} else {
			insert(root, value);
		}
		size++;
	}

	private void insert(Node<Integer, Integer> node, int value) {
		if (node.getKey() > value) {
			if (node.getLeft() != null) { 
				insert(node.getLeft(), value);
			} else {
				node.left = new Node<Integer, Integer>(value);
			}
		} else if (node.getKey() < value) {
			if (node.getRight() != null) {
				insert(node.getRight(), value);
			} else {
				node.right =  new Node<Integer, Integer>(value);
			}
		}
	}	


	public void delete(int value) {
		if (contains(value)) {
			root = delete(root, value);	
			size--;	
		}
	}

	private Node<Integer, Integer> delete(Node<Integer, Integer> node, int value) {
		// Exit statement to where the node that we are going to delete
		// the first if - else if statement takes care of whether or not the node is the root.
		if (node.getKey() == value && !node.hasChildren()) {
			return null;
		} else if (node.getKey() == value && node.hasChildren()) {
			if (node.getLeft() == null && node.getRight() != null) {
				return node.getRight();
			} else if (node.getLeft() != null && node.getRight() == null) {
				return node.getLeft();
			} else {
				return deleteRotateRight(node);
			}
		} else {
			if (node.getKey() > value) {
				node.left = delete(node.getLeft(), value);
				return node;
			} else {
				node.right = delete(node.getRight(), value);
				return node;
			}
		}
	}

	private Node<Integer, Integer> deleteRotateRight(Node<Integer, Integer> node ) {
		Node<Integer, Integer> rightNode = node.getRight();
		// Find public void testName() throws Exception {
			
		// The right most leaf node of the left node, and append the right node of the node that will be deleted to it.
		findRightLeaf(node.getLeft()).right = rightNode;
		return node.getLeft();
	}

	private Node<Integer, Integer> findRightLeaf(Node<Integer, Integer> node) {
		if (node.getRight() == null) {
			return node;
		} else {
			return node.getRight();
		}
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node<Integer, Integer> node, int value) {
		if (node == null) {
			return false;
		}

		if (node.getKey() == value) { 
			return true;
		} else if (node.getKey() > value) {
			return contains(node.getLeft(), value);
		} else {
			return contains(node.getRight(), value);
		}
	}

	public void printBST() {
		printBST(root);
		System.out.println();
	}

	private void printBST(Node<Integer, Integer> node) {
		if (node != null) {
			printBST(node.getLeft());
			System.out.print(node.getKey() + "  ");
			printBST(node.getRight());
		}
	}

	public class Node<K, V> {
		private Node<K, V> left = null;
		private Node<K, V> right = null;
		private K key;
		private V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public boolean hasChildren() {
			return left != null || right != null;
		}

		public boolean childrenHasKey(K key) {
			return right.getKey() == key || left.getKey() == key;
		}

		public boolean hasTwoChildren() {
			return left != null && right != null;
		}

		public Node(K key) {
			this.key = key;
		}

		public Node<K, V> getLeft() {
			return left;
		}

		public Node<K, V> getRight() {
			return right;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}

}