package kata.algorithms;

public class QueueTest {
	public static void testIsEmpty() {
		Queue<Integer> test = new Queue<Integer>();
		assert(test.isEmpty());
		test = loadQueue();
		assert(!test.isEmpty());
	}	

	public static Queue<Integer> loadQueue() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(13);
		queue.enqueue(18);
		queue.enqueue(25);
		return queue;
	}

	public static void testEnqueue() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		assert(queue.size() == 1);
		assert(queue.dequeue() == 10);
	}

	public static void testDequeue() {
		Queue<Integer> test = loadQueue();
		assert(test.dequeue() == 10);
		assert(test.dequeue() == 20);
		assert(test.dequeue() == 13);
		test.enqueue(42);
		assert(test.dequeue() == 18);
		assert(test.dequeue() == 25);
		assert(test.dequeue() == 42);
		assert(test.dequeue()== null);
	}
}