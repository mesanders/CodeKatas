package kata.gameoflife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConwayGameOfLife {
	private final static String DEFAULT_FILE = "../resources/second_ingest.txt";

	public static void main(String[] args) throws InterruptedException, IOException { 
		InputStreamReader fileInputStream = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(fileInputStream);
		Grid grid = new Grid(); 
		grid.readGrid(DEFAULT_FILE);
		
		boolean loop = true;
		while(loop) {
			clearConsole();
			System.out.println("Press any key to exit");
			grid.printGrid();
			grid.nextGenerationGrid();
			Thread.sleep(1000);
			if (bufferedReader.ready()) {
				bufferedReader.read();
				loop = false;
			}
		}
		
	}

	public static void clearConsole() throws InterruptedException, IOException {
		String cmd = "\033[H\033[2J";
		if (System.getProperty("os.name").contains("indows")) {
			cmd = "cls";
		}
		System.out.println("Command is: " + cmd);
		if (cmd.equals("cls")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} else {
			System.out.println(cmd);
		}	
	}
}
