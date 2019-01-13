public class Tiles { //extends Board ??

  private boolean isBomb, isNumber, isFlag, isClicked;
  private int row, col, numNeighborMines;

  public Tiles(int rowVal, int colVal) {
    row = rowVal;
    col = colVal;
    isBomb = false;
    isNumber = false;
    isFlag = false;
    isClicked = false;
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

  public int getNumNeighborMines() {
    return numNeighborMines;
  }

  public void setNumNeighborMines(int value) {
    numNeighborMines = value;
  }

  public boolean isBomb() {
    return isBomb;
  }

  public boolean isNumber() {
    return isNumber;
  }

  public boolean isFlag() {
    return isFlag;
  }

  public boolean isClicked() {
    return isClicked;
  }

  public int row() {
    return row;
  }

  public int col() {
    return col;
  }



}
