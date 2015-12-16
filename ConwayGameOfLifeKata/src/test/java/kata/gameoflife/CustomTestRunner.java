package kata.gameoflife;

import java.io.IOException;
import kata.server.SimpleServerTest;

public class CustomTestRunner {
	private static final String TESTFILE = "bin/default_ingest.txt";
	private ConwayGameOfLife cgol = new ConwayGameOfLife();
	public static final String cut = "CustomTestRunner.";
	private  SimpleServerTest serverThread = null;

	public static void pmr(String runningtest) {
		System.out.println("Running " + cut + " " + runningtest);
	}

	public static void testGrid() throws IOException {
		pmr("testGrid()");
	}

	public static void runGridTest() throws IOException {
		pmr("new GridTest()");
		new GridTest().ReadGridTest();
	}

	public void runSimpleServerTest() {
		 pmr("new SimpleServerTest()");
		 serverThread = new SimpleServerTest();
		  Thread thread = new Thread(serverThread);
		 thread.start();
	}

	public void runTests() throws IOException{
		testGrid();
		runGridTest();
		runSimpleServerTest();
		cleanup();
	}

	public static void main(String[] args) throws IOException {
		new CustomTestRunner().runTests();
	}

	public void cleanup() { 
		pmr("Cleanup Server Thread()");
		 while(serverThread != null && !serverThread.isStarted()) {
		 	// Pause so that the thread doesn't eat up all the CPU space
		 	try { Thread.sleep(500); } catch(Exception e ) { }
		 }
		 pmr("Server has been started.");
		 pmr("serverThread.testConnectionToServer() \tAsserting Simple Server has 'Hello World'");
		 serverThread.testConnectionToServer();
		 pmr("Terminating the server thread");
		serverThread.terminate();
	}
}
