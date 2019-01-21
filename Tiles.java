public class Tiles /*extends Board?? */ {

  private boolean isMine, isFlagged, isRevealed;
  private int x, y, numNearbyMines;
  private String symbol;

  //constructor for Tiles
  public Tiles(int xVal, int yVal, boolean isMined) {
    x = xVal;
    y = yVal;
    isMine = isMined;
    isFlagged = false;
    isRevealed = false;
    numNearbyMines = 0;
    //the symbol that is going to display what kind of tile it is
    symbol = "_";
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

/*
this sets the symbols accordingly, if it is revealing a mine,
it will become an x if it is a mine.
however, if it was flagged, then a F will take over and you wil know that a mine is there.
*/
  public void setSymbol() {
    if (isRevealed) {
      if (isMine) {
        symbol = "X";
      }
      else {
        symbol = "" + numNearbyMines;
      }
    }
    if (!isRevealed && isFlagged) {
      symbol = "F";
    }
    if (!isRevealed && !isFlagged) {
      symbol = "_";
    }
  }

  /*
  //different actions depending on whether the tile is
  //already flagged, not flagged, revealed, etc.
  //needs more work probably.
  */

  public void setFlag() {
    isFlagged = !isFlagged;
  }

}
