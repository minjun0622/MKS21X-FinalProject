public class Tiles{

  private boolean isClicked; //, isFlagged, isRevealed;
  //private int x, y, numNearbyMines; I think that the board has this class.
  private String symbol;

  //constructor for Tiles
  public Tiles(/*int xVal, int yVal, */boolean isMined) {
    /*x = xVal;
    y = yVal;
    */
    //The X and Y coordinates
    isClicked = false;
    this.isMined = isMined;
    symbol = null;
  }
  /*
  needs to be worked on/is toString for Tiles needed?
  public String toString() {
    String result = "";
    if (isFlag)
      result += "F";
    if (isBomb && isClicked)
      result += "B";
    return result;
  }*/

  //returns numNearbyMines
  public int getNumNearbyMines() {
    return numNearbyMines;
  }

  //sets the numNearbyMines by a given value
  public void setNumNearbyMines(int value) {
    numNearbyMines = value;
  }

  //returns isMine
  public boolean isMine() {
    return isMine;
  }

  //returns isFlagged
  public boolean isFlagged() {
    return isFlagged;
  }

  //returns isRevealed
  public boolean isRevealed() {
    return isRevealed;
  }

  public void reveal() {
    isRevealed = true;
  }

  //returns the x position of the Tile
  public int getX() {
    return x;
  }

  //returns the y position of the Tile
  public int getY() {
    return y;
  }

  //returns the symbol of the Tile
  public String getSymbol() {
    return symbol;
  }

  public void setSymbol() {
    if (isRevealed) {
      if (isMine) {
        symbol = "X";
      }
      else {
        symbol = "" + numNearbyMines;
      }
    }
    else symbol = "_";
  }


  /*
  //different actions depending on whether the tile is
  //already flagged, not flagged, revealed, etc.
  //needs more work probably.
  public void setFlag(boolean flagged) {
    isFlagged = flagged;
    if (!isRevealed) {
      if (isFlagged)
        symbol = "F";
    }
  }
  */



}
