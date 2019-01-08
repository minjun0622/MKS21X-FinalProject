public abstract class Board  {

Tiles[][] data;

//constructor for board.
public Board(int x, int y) {
  int x = col;
  int y = row;
}

//makes the board.
  public String toString() {
    String result = "|";
    for (int x = 0; x < data.length; x++) {
      for (int y = 0; y < data[x].length; y++) {
        result += " x";
      }
      result += "|" + "\n" + "|";
    }
  }
  /*
  | x x x x x x x|
  | x x x x x x x|
  | x x x x x x x|
  | x x x x x x x|
  | x x x x x x x|
  */

//a helper method in which we can use to create different keys on the board.
  public int randomize(int x) {
    Math.random()
  }



//display a new window when the game is won.
//make it so that if there are no mines left.
  public String win() {
    if (numMines() = 0) {
      System.out.println("WINNING MESSAGE.")
    }

  }

//if a bomb is clicked.
  public String lose() {
    if ()


  }


//returns the number of mines we have.
  public int numMines() {
    int count;
    for (int i = 0; i < data.length; i++) {
      for (int x = 0; x < data[x].length; x++) {
        if (data[i][x].equals "x") {
          count++;
        }
      }
    }
  }
  







}
