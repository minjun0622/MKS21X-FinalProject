public class Tiles extends Board{

  boolean isBomb, isNumber, isFlag, isClicked;
  int row, col;

  public Tiles(int rowVal, int colVal) {
    row = rowVal;
    col = colVal;
    isBomb = false;
    isNumber = false;
    isFlag = false;
    isClicked = false;
  }

  public String toString() {
    String result = "";
    if (isFlag)
      result += "F";
    if (isBomb && isClicked)
      result += "B";
    return result;
  }





}
