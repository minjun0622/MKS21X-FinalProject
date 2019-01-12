public class Tiles /*extends Board?? */ {

  private boolean isMine, isFlagged, isRevealed;
  private int x, y, numNearbyMines;
  private String symbol;

  public Tiles(int xVal, int yVal, boolean isMined) {
    x = xVal;
    y = yVal;
    isMine = isMined;
    isFlagged = false;
    isRevealed = false;
    numNearbyMines = 0;
    symbol = " ";
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

  public int getNumNearbyMines() {
    return numNearbyMines;
  }

  public void setNumNearbyMines(int value) {
    numNearbyMines = value;
  }

  public boolean isMine() {
    return isMine;
  }

  public boolean isFlagged() {
    return isFlagged;
  }

  public boolean isRevealed() {
    return isRevealed;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public String getStymbol() {
    return symbol;
  }

  public void reveal() {
    isRevealed = true;
  }

  public void setFlag(boolean flagged) {
    isFlagged = flagged;
    if (!isRevealed) {
      if (isFlagged)
        symbol = "F";

    }
  }



}
