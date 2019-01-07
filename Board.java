public class Board extends MineSweeper {

char[][] data;

//constructor for board.
public Board() {

}

//makes the board.
  public String toString(int x, int y) {
    String result = '';
    for (int x = 0; x < data.length; x++) {
      for (int y = 0; y < data[x].length; y++) {
        result += 'x ';
      }
    }
  }

//a helper method in which we can use to create different keys on the board.
  public int randomize(int x) {
    Math.random()
  }





}
