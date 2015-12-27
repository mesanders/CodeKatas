package kata.algorithms;

public class Queue<T> {
	private LinkedList<T> linkedListQueue = new LinkedList<>();

	public void enqueue(T value) {
		linkedListQueue.insert(value);
	}

	public T dequeue() {
		return linkedListQueue.popTop();
	}

	public int size() {
		return linkedListQueue.getSize();
	}

	public boolean isEmpty() {
		return linkedListQueue.isEmpty();
	}
}