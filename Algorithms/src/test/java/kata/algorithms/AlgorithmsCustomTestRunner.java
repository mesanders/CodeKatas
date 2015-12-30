package kata.algorithms;

public class AlgorithmsCustomTestRunner {
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_BLACK = "\u001B[1;30m";
public static final String ANSI_RED = "\u001B[1;31m";
public static final String ANSI_GREEN = "\u001B[1;32m";
public static final String ANSI_YELLOW = "\u001B[1;33m";
public static final String ANSI_BLUE = "\u001B[1;34m";
public static final String ANSI_PURPLE = "\u001B[1;35m";
public static final String ANSI_CYAN = "\u001B[1;36m";
public static final String ANSI_WHITE = "\u001B[1;37m";

	public static void main(String[] args) {
		runRBBinarySearchTreeTest();
		runLinkedListTest();
		runSortingTest();
		runQueueTest();
		runStackTest();
	}

	public static void runSortingTest() {
		SortingTest test = new SortingTest();

		echo("SortingTest bubbleSort()");
		test.bubbleSortTest();

		echo("SortingTest testSwaps()");
		test.testSwaps();

		echo("SortingTest insertionSort()");
		test.insertionSortTest();

		echo("SortingTest testMerge()");
		test.testMerge();

		echo("SortingTest testMergeSort()");
		test.testMergeSort();

		echo("SortingTest testRadixSort()");
		test.testRadixSort();
	}

	public static void runStackTest() {
		StackTest test = new StackTest();

		echo("StackTest testPop()");
		test.testPop();

		echo("StackTest testPush()");
		test.testPush();
	}

	public static void runQueueTest() {
		QueueTest test = new QueueTest();

		echo("QueueTest testIsEmpty()");
		test.testIsEmpty();

		echo("QueueTest testEnqueue()");
		test.testEnqueue();

		echo("QueueTest testDequeue()");
		test.testDequeue();
	}

	public static void runRBBinarySearchTreeTest() {
		echo("RBBinarySearchTreeTest testNode()");
		RBBinarySearchTreeTest test = new RBBinarySearchTreeTest();
		test.testNode();

		echo("RBBinarySearchTreeTest testInsert()");
		test.testInsert();

		echo("RBBinarySearchTreeTest testDelete()");
		test.testDelete();
	}

	public static void runLinkedListTest() {
		LinkedListTest linkedListTest = new LinkedListTest();
		echo("LinkedListTest testNode()");
		linkedListTest.testNode();	

		echo("LinkedListTest testInsert()");
		linkedListTest.testInsert();

		echo("LinkedListTest testRemove()");
		linkedListTest.testRemove();

		echo("LinkedListTest testClear()");
		linkedListTest.testClear();

		echo("LinkedListTest testPopTop()");
		linkedListTest.testPopTop();

		echo("LinkedListTest testPopBottom()");
		linkedListTest.testPopBottom();
	}

	public static void echo(String message) {
		System.out.println(ANSI_WHITE + "Running: \t" + message + ANSI_RESET);		
	}

}