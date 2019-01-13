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

/*

//This Constructor is created only for
//the purpose of the main method to test
//the checkNeighbors method.

public Board(int rowVal, int colVal) {
  board = new Tiles[rowVal][colVal];
  row = rowVal;
  col = colVal;
}

*/



//this method contains 3 helpher methods that will
//actually create the board
private void createBoard() {
  placeMines();
  fillBoard();
  calculateNearbyMines();
}

//selects a random position of the board and makes import junit.framework.TestCase;
//a bomb tile. While loop makes sure that the numMines of mines are placed.
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

//fills board by making the null positions of the
//board into regular tiles.
public void fillBoard() {
  for (int r = 0; r < row; r++) {
    for (int c = 0; c < col; c++) {
      if (board[r][c] == null) {
        board[r][c] = new Tiles(r, c, false);
      }
    }
  }
}

//loops through every tile on the board and if it is
//not a bomb tile, then it checks its 8 neighbor tiles.
public void calculateNearbyMines() {
  for (int r = 0; r < row; r++) {
    for (int c = 0; c < col; c++) {
      if (!board[r][c].isMine())
        checkNeighbors(r, c);
    }
  }
}

//helper method for the calculateNearbyMines method.
//checks 8 neighboring tiles and the mineCount
//keeps track of how many mines are present in the 8
//neighboring tiles. It then sets the numNearbyMines
//of the tile[r][c] by the mineCount.
public void checkNeighbors(int r, int c) {
  int mineCount = 0;
  if (r-1 >= 0 && c-1 >= 0 && board[r-1][c-1].isMine())
    mineCount++;
  if (r-1 >= 0 && board[r-1][c].isMine())
    mineCount++;
  if (r-1 >= 0 && c+1 < row && board[r-1][c+1].isMine())
    mineCount++;
  if (c-1 >= 0 && board[r][c-1].isMine())
    mineCount++;
  if (c+1 < col && board[r][c+1].isMine())
    mineCount++;
  if (r+1 < row && c-1 >= 0 && board[r+1][c-1].isMine())
    mineCount++;
  if (r+1 < row && board[r+1][c].isMine())
    mineCount++;
  if (r+1 < row && c+1 < col && board[r+1][c+1].isMine())
    mineCount++;
  board[r][c].setNumNearbyMines(mineCount);
}

//an accessor method that returns the board.
public Tiles[][] getBoard() {
  return board;
}




/*

//this is a main method made to check if
//the checkNeighbors() method work or not.
//It works properly.

public static void main(String[] args) {
  Board test = new Board(2, 2);
  Tiles[][] boardd = test.getBoard();
  boardd[0][0] = new Tiles(0, 0, false);
  boardd[0][1] = new Tiles(0, 1, true);
  boardd[1][0] = new Tiles(1, 0, true);
  boardd[1][1] = new Tiles(1, 1, true);
  test.checkNeighbors(0, 0);
  System.out.println(boardd[0][0].getNumNearbyMines());
  //should return 3.
  //it returns 3.
}

*/







/*
---------------old code---------------

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
