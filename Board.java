import java.util.*;
import java.io.*;

public class Board {
  private Tile[][] board;
  private int row, col, numMines, numMinedTile, revealedTile;
  private boolean clickedMine, exited;
  private ArrayList<Tile> minedTile;

  //constructor for board.
  public Board(int rowVal, int colVal, int possibility) {
    row = rowVal;
    col = colVal;
    board = new Tile[rowVal][colVal];
    clickedMine = false;
    exited = false;
    createBoard(possibility);
  }

//creates an empty Board. Needed when nothing is entered.
  public Board() {
    board = null;
  }

  //This method checks if it is a mine, if it is then you add.
  public void calculateMinedTile() {
    minedTile = new ArrayList<Tile>();
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (board[r][c].isMine())
          minedTile.add(board[r][c]);
      }
    }
  }

  //Checks if all the mines are flagged, if so then return true.
  public boolean flaggedAllMines() {
    for (int i = 0; i < minedTile.size(); i++) {
      if (!minedTile.get(i).isFlagged())
        return false;
    }
    return true;
  }

  //this method contains 3 helpher methods that will
  //actually create the board
  private void createBoard(int possibility) {
    placeMines(possibility);
    calculateNearbyMines();
    calculateNumMines();
    calculateMinedTile();
  }

  //returns the number of Tile that have been clicked.
  public int numMinedTile() {
    return numMinedTile;
  }

  //returns the number of mines there are.
  public void calculateNumMines() {
    int result = 0;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (board[r][c].isMine())
          result++;
      }
    }
    numMinedTile = result;
  }

  //selects a random position of the board and makes import junit.framework.TestCase;
  //a bomb tile. While loop makes sure that the numMines of mines are placed.
  public void placeMines(int possibility) {
    Random random = new Random();
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (random.nextInt(100) < possibility)
          board[r][c] = new Tile(r, c, true);
        else board[r][c] = new Tile(r, c, false);
      }
    }
  }

  //fills board by making the null positions of the
  //board into regular Tile.
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
  //not a bomb tile, then it checks its 8 neighbor Tile.
  public void calculateNearbyMines() {
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (!board[r][c].isMine())
          checkNeighbors(r, c);
      }
    }
  }

  //helper method for the calculateNearbyMines method.
  //checks 8 neighboring Tile and the mineCount
  //keeps track of how many mines are present in the 8
  //neighboring Tile. It then sets the numNearbyMines
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

  //returns true if it is clicked.
  public boolean clickedMine() {
    return clickedMine;
  }

  //returns a boolean on whether it is exited or not.
  public boolean exited() {
    return exited;
  }

  //creates the board!
  /*
    0 1 2 3 4 5
  0 _ _ _ _ _ _
  1 _ _ _ _ _ _
  2 _ _ _ _ _ _
  3 _ _ _ _ _ _
  4 _ _ _ _ _ _
  5 _ _ _ _ _ _
  */
  
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

  //It checks if it is a mine
  public void reveal(int r, int c) {
    ArrayList<Tile> nonMineNeighborTile = checkNonMineTile(r, c);
    if (!board[r][c].isRevealed()) {
      board[r][c].reveal();
      revealedTile++;
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

  //sets a point on the board if flagged.
  public void flag(int r, int c) {
    board[r][c].setFlag();
    board[r][c].setSymbol();
  }

  //returns the boolean true if everything on the game works and you won.
  public boolean boardComplete() {
    return row * col - numMinedTile - revealedTile == 0 && flaggedAllMines();
  }

  //checks the neighbor and sees if it is a mine or not.
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

  //scanner for the main method.
  public void getInput (Scanner scanner) {
    String input = scanner.next();
    int rowValue = Integer.parseInt(scanner.next());
    int colValue = Integer.parseInt(scanner.next());
    if (input.equals("r"))
      reveal(rowValue, colValue);
    if (input.equals("e"))
      exited = true;
    if (input.equals("f"))
      flag(rowValue, colValue);
    }
    /*
    //this is a main method made to check if
    //the checkNeighbors() method work or not.
    //It works properly.
    public static void main(String[] args) {
    Board test = new Board(6, 6);
    Tile[][] boardd = test.getBoard();
    test.fillBoard();
    boardd[0][0] = new Tile(0, 0, true);
    //boardd[0][1] = new Tile(0, 1, true);
    //boardd[1][0] = new Tile(1, 0, true);
    //boardd[1][1] = new Tile(1, 1, true);
    //test.checkNeighbors(0, 0);
    //System.out.println(boardd[0][0].getNumNearbyMines());
    System.out.println(test);
    //should return 3.
    //it returns 3.
    */

/*
                              !!!OLD CODE!!!
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
}
*/

}
