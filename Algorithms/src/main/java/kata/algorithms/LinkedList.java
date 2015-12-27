package kata.algorithms;

public class LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public Node<T> getTail() {
		return tail;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public boolean contains(T key) {
		return contains(key, head);
	}

	public int getSize() {
		return size;
	}

	public void clear() {
		clear(head);
		head = null;
		tail = null;
		size = 0;
	}

	public T popTop() {
		if (isEmpty()) {
			return null;
		}
		T value = head.getValue();
		head = head.next;
		size--;
		return value;
	}

	public T popBottom() {
		if (isEmpty() || tail.getValue() == null) {
			return null;
		}

		T value = tail.getValue();

		if (tail.prev != null) {
			tail = tail.prev;
			tail.next = null;
		} else {
			tail = null;
			head = null;
		}
		size--;	
		return value;
	}

	private void clear(Node<T> node) {
		if (node.next == null) {
			return;
		}
		clear(node.next);
		node.next = null;
	}

	private boolean contains(T key, Node<T> node) {
		if (node == null) {
			return false;
		} else if (node.getValue().equals(key)) {
			return true;
		} else {
			return contains(key, node.next);
		}
	}

	public void remove(T key) {
		remove(head, key);
	}

	private void remove(Node<T> node, T key) {
		if (node == null) {
			return;
		} else if (node.getValue().equals(key) && node == head) {
			head = head.next;	
		} else {
			Node<T> next = node.getNext();
			node.next = next;
			next.prev = node.prev;
		}
		size--;
	}

	public void insert(T key) {
		Node<T> node = new Node<T>(key);
		size++;
		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
	}

	public void printAll() {
		print(head);
	}

	private void print(Node<T> node) {
		if (node != null) {
			System.out.print(node.getValue() + " ");
			print(node.getNext());
		} else {
			System.out.println();
		}
	}

	public void printAllReverse() {
		printReverse(tail);
	}

	private void printReverse(Node<T> node) {
		if (node!=null) {
			System.out.print(node.getValue() + " ");
			printReverse(node.getPrev());
		} else {
			System.out.println();
		}
	}

	public class Node<T> {
		private Node<T> next;
		private Node<T> prev;
		private T value;

		public Node(T val) {
			value = val;
		}

		public T getValue() {
			return value;
		}

		public boolean hasNext() {
			return next != null;	
		}

		public boolean hasPrev() {
			return prev != null;
		}

		public Node<T> getNext() {
			return next;
		}

		public Node<T> getPrev() {
			return prev;
		}
	}
}