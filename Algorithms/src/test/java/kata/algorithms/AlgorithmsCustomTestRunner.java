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
	}

	public static void runRBBinarySearchTreeTest() {
		echo("RBBinarySearchTreeTest testNode()");
		RBBinarySearchTreeTest test = new RBBinarySearchTreeTest();
		test.testNode();

		echo("RBBinarySearchTreeTest testInsert()");
		test.testInsert();
	}

	public static void echo(String message) {
		System.out.println(ANSI_WHITE + "Running: \t" + message + ANSI_RESET);		
	}

}