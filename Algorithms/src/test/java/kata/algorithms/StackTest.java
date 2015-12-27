package 	kata.algorithms;

public class StackTest {

	public static void testPop() {
		Stack<Integer> test = new Stack<>();
		test.push(10);
		test.push(20);
		test.push(25);
		test.push(13);
		assert(test.pop() == 13);
		assert(test.pop() == 25);
		assert(test.pop() == 20);
		assert(test.pop() == 10);
		assert(test.pop() == null);
	}

	public static void testPush() {
		Stack<Integer> test = new Stack<>();
		test.push(10);
		test.push(20);
		assert(test.size() == 2);
	}	
	
}