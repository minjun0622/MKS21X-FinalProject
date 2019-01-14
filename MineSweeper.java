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
  while (!board.win() && > 0) {
    board.display();
    board.getUserInput(scanner);
  }
  board.display();
  if (board.finished()) {
    System.out.println("You have beat the game. You're a genius!");
  }
  else {
    System.out.println("You have lost. :(");
  }
  scanner.close();

  }
  }
