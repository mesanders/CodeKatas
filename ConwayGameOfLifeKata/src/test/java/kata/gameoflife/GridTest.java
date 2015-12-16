package kata.gameoflife;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.List;
import java.io.IOException;

public class GridTest {
 private Grid grid = new Grid();
 private static String TESTFILE = "default_ingest.txt";
 private boolean[][] readGrid;

 public void ReadGridTest() throws IOException {
	readGrid = grid.readGrid(TESTFILE);
	System.out.println("Running assertGridProperties()");
	assertGridPopulated();
	System.out.println("Running assertAliveNeighbors()");
	assertAliveNeighorCheck();
	System.out.println("Running assertCheckNeighborBounds()");
	assertCheckNeighborBounds();
  System.out.println("Running assertUpdatedCellState()");
  assertUpdatedCellState();
  	System.out.println("Running nextGenerationGrid()");
  	assertUpdateGridState();
  }

  public void assertHeight() {
  	assert(grid.getHeight() == 8);
  	assert(grid.getWidth() == 4);
  }

 public void assertGridPopulated() {
	assert(readGrid[1][4] == true);
	assert(readGrid[1][3] == false);
	assert(readGrid[1][5] == false);
	assert(readGrid[2][4] == true);
 	assert(readGrid[0][0] == false);
   assert(readGrid[3][7] == false);
 }

 public void assertAliveNeighorCheck(){
  	assert(grid.getNumAliveNeighbors(1, 4) == 2);
  	assert(grid.getNumAliveNeighbors(0, 0) == 0);
  	assert(grid.getNumAliveNeighbors(0, 4) == 1);
 }

 public void assertNeighborAlive() {
 	assert(grid.isNeighborAlive(1, 1) == false);
 	assert(grid.isNeighborAlive(1, 4) == true);
 	assert(grid.isNeighborAlive(2, 4) == true);
 	assert(grid.isNeighborAlive(-1, -1) == false);
 	assert(grid.isNeighborAlive(8, 8) == false);
 }

 public void assertCheckNeighborBounds(){
   	assert(grid.checkNeighborBounds(0,0) == true);
   	assert(grid.checkNeighborBounds(-1,0) == false);
   	assert(grid.checkNeighborBounds(8,7) == false);
   	assert(grid.checkNeighborBounds(1,8) == false);
   	assert(grid.checkNeighborBounds(3,7) == true);
 }

 public void assertUpdatedCellState(){
   assert(grid.updateCellState(1,3) == true);
   assert(grid.updateCellState(1,4) == true);
   assert(grid.updateCellState(0,5) == false);
   assert(grid.updateCellState(2,3) == true);
   assert(grid.updateCellState(7,7) == false);
 }

 public void assertUpdateGridState() {
 	boolean[][] updatedGrid = grid.nextGenerationGrid();
 	assert(grid.isNeighborAlive(1,1) == false);
 	assert(grid.isNeighborAlive(1, 3) == true);
 	assert(grid.isNeighborAlive(7,7) == false);
 	assert(grid.isNeighborAlive(2, 4) == true);
 }
}
