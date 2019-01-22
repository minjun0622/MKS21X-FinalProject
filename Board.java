import java.util.*;
import java.io.*;

public class Board {
  private Tile[][] board;
  private int row, col, numMines, numMinedTiles, revealedTiles;
  private boolean clickedMine;
  private ArrayList<Tile> minedTiles;

  //constructor for board.
  public Board(int rowVal, int colVal, int numOfMines) {
    row = rowVal;
    col = colVal;
    numMines = numOfMines;
    board = new Tile[rowVal][colVal];
    clickedMine = false;
    createBoard();
  }

  public Board(int rowVal, int colVal) {
    row = rowVal;
    col = colVal;
    numMines = 2;
    board = new Tile[rowVal][colVal];
  }

  public Board() {
    board = null;
  }

  public void calculateMinedTiles() {
    minedTiles = new ArrayList<Tile>();
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (board[r][c].isMine())
          minedTiles.add(board[r][c]);
      }
    }
  }

  public boolean flaggedAllMines() {
    for (int i = 0; i < minedTiles.size(); i++) {
      if (!minedTiles.get(i).isFlagged())
        return false;
    }
    return true;
  }

  //this method contains 3 helpher methods that will
  //actually create the board
  private void createBoard() {
    placeMines();
    fillBoard();
    calculateNearbyMines();
    calculateNumMines();
  }

  public int numMinedTiles() {
    return numMinedTiles;
  }

  public void calculateNumMines() {
    int result = 0;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (board[r][c].isMine())
          result++;
      }
    }
    numMinedTiles = result;
  }

  //selects a random position of the board and makes import junit.framework.TestCase;
  //a bomb tile. While loop makes sure that the numMines of mines are placed.
  public void placeMines() {
    Random rand = new Random();
    int minesLeftToBePlaced = numMines;
    while(minesLeftToBePlaced > 0) {
      int randX = rand.nextInt(row);
      int randY = rand.nextInt(col);
      if (board[randX][randY] == null) {
        board[randX][randY] = new Tile(randX, randY, true);
        minesLeftToBePlaced--;
      }
    }
  }

  //fills board by making the null positions of the
  //board into regular tile.
  public void fillBoard() {
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (board[r][c] == null) {
          board[r][c] = new Tile(r, c, false);
        }
      }
    }
  }

  //loops through every tile on the board and if it is
  //not a bomb tile, then it checks its 8 neighbor tile.
  public void calculateNearbyMines() {
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (!board[r][c].isMine())
          checkNeighbors(r, c);
      }
    }
  }

  //helper method for the calculateNearbyMines method.
  //checks 8 neighboring tile and the mineCount
  //keeps track of how many mines are present in the 8
  //neighboring tile. It then sets the numNearbyMines
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
  public Tile[][] getBoard() {
    return board;
  }

  public boolean clickedMine() {
    return clickedMine;
  }

  public String toString() {
    String result = "    ";
    for (int i = 0; i < row; i++) {
      result += i + " ";
    }
    result += "\n\n";
    for (int r = 0; r < row; r++) {
      result += " " + r + "  ";
      for (int c = 0; c < col; c++) {
        result += board[r][c].getSymbol() + " ";
      }
      result += "\n";
    }
    return result;
  }

  public void reveal(int r, int c) {
    ArrayList<Tile> nonMineNeighborTile = checkNonMineTile(r, c);
    if (!board[r][c].isRevealed()) {
      board[r][c].reveal();
      revealedTiles++;
      if (board[r][c].isMine()) {
        clickedMine = true;
        board[r][c].setSymbol();
      }
      else {
        checkNeighbors(r, c);
        board[r][c].setSymbol();
        if (board[r][c].getNumNearbyMines() == 0) {
          for (int i = 0; i < nonMineNeighborTile.size(); i++) {
            if (!nonMineNeighborTile.get(i).isRevealed()) {
              reveal(nonMineNeighborTile.get(i).getX(), nonMineNeighborTile.get(i).getY());
            }
          }
        }
      }
    }
  }

  public void flag(int r, int c) {
    board[r][c].setFlag();
    board[r][c].setSymbol();
  }

  public boolean boardComplete() {
    return row * col - numMinedTiles - revealedTiles == 0 && flaggedAllMines();
  }

  public ArrayList<Tile> checkNonMineTile(int r, int c) {
    ArrayList<Tile> result = new ArrayList<Tile>();
    if (r-1 >= 0 && c-1 >= 0 && !board[r-1][c-1].isMine())
      result.add(board[r-1][c-1]);
    if (r-1 >= 0 && !board[r-1][c].isMine())
      result.add(board[r-1][c]);
    if (r-1 >= 0 && c+1 < row && !board[r-1][c+1].isMine())
      result.add(board[r-1][c+1]);
    if (c-1 >= 0 && !board[r][c-1].isMine())
      result.add(board[r][c-1]);
    if (c+1 < col && !board[r][c+1].isMine())
      result.add(board[r][c+1]);
    if (r+1 < row && c-1 >= 0 && !board[r+1][c-1].isMine())
      result.add(board[r+1][c-1]);
    if (r+1 < row && !board[r+1][c].isMine())
      result.add(board[r+1][c]);
    if (r+1 < row && c+1 < col && !board[r+1][c+1].isMine())
      result.add(board[r+1][c+1]);
    return result;
  }

  public void getInput (Scanner scanner) {
    String input = scanner.next();
    int rowValue = Integer.parseInt(scanner.next());
    int colValue = Integer.parseInt(scanner.next());
    if (input.equals("r"))
      reveal(rowValue, colValue);
    if (input.equals("e"))
      clickedMine = true;
    if (input.equals("f"))
      flag(rowValue, colValue);
    }

    //this is a main method made to check if
    //the checkNeighbors() method work or not.
    //It works properly.

    public static void main(String[] args) {
    Board test = new Board(6, 6);
    Tile[][] boardd = test.getBoard();
    test.fillBoard();
    boardd[0][0] = new Tile(0, 0, true);
    System.out.println(test);
  }

}
