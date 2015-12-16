package kata.gameoflife;

import java.util.Arrays;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.List;
import java.io.IOException;


public class Grid {
  private boolean[][] grid;
  private int width;
  private int height;

  public Grid(String filename) throws IOException{
    readGrid(filename);
  }

  public Grid() {

  }

  public boolean[][] readGrid(String file) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(file), Charset.forName("UTF-8"));
    height = lines.size();
    width = lines.get(0).toCharArray().length;
 
    grid = new boolean[height][width];
  
    for (int i = 0; i < lines.size(); i++) {
      char[] charline = lines.get(i).toCharArray();
      for (int c = 0; c < charline.length; c++) {
        if (charline[c] == '*') {
          grid[i][c] = true;
        } else  {
          grid[i][c] = false;
        }
      }
    }

    
    return grid;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width; 
  }

  public int getNumAliveNeighbors(int x, int y){
    int counter = 0;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        if (!(i == 0 && j == 0)) {
          if (isNeighborAlive(x + i, j + y)) { counter++; };
        }
      }
    }
    return counter;
  }

  public boolean isNeighborAlive(int x, int y) {
    if (checkNeighborBounds(x, y)) {
      return grid[x][y];
    }
    return false;
  }

  public boolean checkNeighborBounds(int x, int y){
    int width = grid.length - 1;
    int height  = grid[width].length - 1;
    if(x < 0 || y  < 0 || x > width || y  > height ){
      return false;
    }
    return true;
  }

  public boolean updateCellState(int x, int y){
    int aliveNeighbor = getNumAliveNeighbors(x, y);
    boolean isAlive = isNeighborAlive(x, y);

    if(isAlive && (aliveNeighbor == 2 || aliveNeighbor == 3)){
      return true;
    }
    if((!isAlive) && aliveNeighbor == 3){
      return true;
    }

    return false;

  }

  public void printGrid() {
    System.out.print("\n\n\n\t\t\t\t");
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (isNeighborAlive(i, j)) {
          System.out.print("*");
        } else {
          System.out.print("-");
        }
      }
      System.out.print("\n\t\t\t\t");
    }
    System.out.print("\n\n\n");
  }

  public boolean[][] nextGenerationGrid() {
    boolean[][] updatedGrid = new boolean[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        updatedGrid[i][j] = updateCellState(i, j);
      }
    }   

     grid = updatedGrid;
      return updatedGrid;
  }
}
