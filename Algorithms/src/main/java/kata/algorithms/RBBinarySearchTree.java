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
		private Node left = null;
		private Node right = null;
		private K key;
		private V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public Node(K key) {
			this.key = key;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
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