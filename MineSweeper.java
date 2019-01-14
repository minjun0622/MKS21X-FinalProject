import java.util.Scanner;

public class MineSweeper {

/*
public static void putString(int r, int c,Terminal t, String s){
  t.moveCursor(r,c);
  for(int i = 0; i < s.length();i++){
    t.putCharacter(s.charAt(i));
  }
}
*/

public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  Board board = new Board(10, 10, 5);
  System.out.println("x = row and y = col.");
  /* I want something like a coordinates system the user can select the coordinates using a number inputting system and then it'll mark it.
  */
    System.out.println("You have beat the game. You're a genius!");
  }
  else {
    System.out.println("You have lost. :(");
  }
  scanner.close();

  }
  }
