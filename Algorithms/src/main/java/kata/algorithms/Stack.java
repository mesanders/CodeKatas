package kata.algorithms;

public class Stack<T> {
	private LinkedList<T> linkedList = new LinkedList<>();

	public int size() {
		return linkedList.getSize();
	}

	public void push(T value) {
		linkedList.insert(value);
	}

	public T pop() {
		return linkedList.popBottom();
	}

	public void print() {
		linkedList.printAllReverse();
	}
}