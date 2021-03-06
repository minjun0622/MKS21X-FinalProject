public class Tile {
  private boolean isMine, isFlagged, isRevealed;
  private int x, y, numNearbyMines;
  private String symbol;

  //constructor for Tile
  public Tile(int xVal, int yVal, boolean isMined) {
    x = xVal;
    y = yVal;
    isMine = isMined;
    //"X"
    isFlagged = false;
    //"F"
    isRevealed = false;
    //will display a number.
    numNearbyMines = 0;
    //the symbol that is going to display what kind of tile it is
    symbol = "_";
  }
  /*
  needs to be worked on/is toString for Tile needed?
  public String toString() {
    String result = "";
    if (isFlag)
      result += "F";
    if (isBomb && isClicked)
      result += "B";
    return result;
    not needed
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

  //changes isFlagged boolean to its
  //opposite.
  public void setFlag() {
    isFlagged = !isFlagged;
  }
}
