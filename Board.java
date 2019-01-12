import java.util.*;
import java.io.*;

public /*abstract*/ class Board {

private Tiles[][] board;
private int row, col, numMines;

//constructor for board.
public Board(int rowVal, int colVal, int numOfMines) {
  row = rowVal;
  col = colVal;
  numMines = numOfMines;
  board = new Tiles[rowVal][colVal];
  createBoard();
}

private void createBoard() {
  placeMines();
  fillBoard();
  calculateNearbyMines();
}

public void placeMines() {
  Random rand = new Random();
  int randX = rand.nextInt(row);
  int randY = rand.nextInt(col);
  int minesLeftToBePlaced = numMines;
  while(minesLeftToBePlaced >= 0) {
    if (board[randX][randY] == null) {
      board[randX][randY] = new Tiles(randX, randY, true);
      minesLeftToBePlaced--;
    }
  }
}

public void fillBoard() {
  for (int r = 0; r < row; r++) {
    for (int c = 0; c < col; c++) {
      if (board[r][c] == null) {
        board[r][c] = new Tiles(r, c, false);
      }
    }
  }
}

public void calculateNearbyMines() {
  
}




/*
//makes the board.
  public String toString(int x, int y) {
    String result = "";
    for (int x = 0; x < data.length; x++) {
      for (int y = 0; y < data[x].length; y++) {
        s += " " + data[i][x];
        }
        s += "|" + '\n' + "|";
      }
    }

//a helper method in which we can use to create different keys on the board.
  public int randomize(int x) {
    Math.random();
  }

  public String win() {
    if (numMines = 0) {
      //return winning message.
    }
  }

  public String lose() {
    if (isClicked )
    //return error message. Not sure where these methods belong.
  }

  public

  */





}
