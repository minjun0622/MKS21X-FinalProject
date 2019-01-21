import java.util.*;
import java.io.*;


public class MineSweeper {
  public static void main(String[] args) {
    //start game with intended difficulty.

    Board board = new Board(1, 1);
    if (args.length == 0) {
      System.out.println("Please insert the difficulty. There are easy, medium, hard. Have fun.");
    }
    //if nothing is entered while running, then this message will display.
    //You need to enter a difficulty to play.

    else {
      if (args[0].equals("easy"))
        board = new Board(5, 5);
        //sets a board by the size of 5x5.

      if (args[0].equals("medium"))
        board = new Board(7, 7);
        //sets a baord by the size of 7x7.

      if (args[0].equals("hard"))
        board = new Board(9, 9);
        //sets a board by the size of 9x9.
      }


    Scanner scanner = new Scanner(System.in);

    board.fillBoard();
    board.calculateNearbyMines();
    board.placeMines();

    while (!board.clickedMine() || board.isFlagged()) {
      System.out.println();
      System.out.println();
      System.out.println(board);
      System.out.println("Format for revealing a Tile: r rowValue colValue ");
      System.out.println("Ex: r 0 0");
      System.out.println();
      System.out.println("Format for flagging a Tile: f rowValue colValue");
      System.out.println("Ex: f 0 0");
      System.out.println();
      System.out.println("Format for exiting the game: e anyNumber anyNumber");
      System.out.println("Ex: e 10000 1");
      System.out.println();
      board.getInput(scanner);
    }
    System.out.println();
    System.out.println();

    System.out.println(board);
    System.out.println("You clicked on the mine/exited.");
    scanner.close();
  }
}
