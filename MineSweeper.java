import java.util.*;
import java.io.*;

public class MineSweeper {
  public static void main(String[] args) {
    //start game with intended difficulty.
    if (args.length == 0) {
      System.out.println("Please insert the difficulty. There are easy, medium, hard. Have fun.");
    }

    if (args[1].equals("easy")) {
    int x = 5;
    int y = 5;
    Board board = new Board(x,y);
  }

    if (args[1].equals("medium")) {
      int x = 10;
      int y = 10;
      Board board = new Board(x,y);
    }

    if (args[1].equals("hard")) {
      int x = 15;
      int y = 15;
      Board board = new Board(x,y);
    }

    Scanner scanner = new Scanner(System.in);
    //Board board = new Board(7, 7);

    /*
    _ _ _ _ _ _
    _ _ _ _ _ _
    _ _ _ _ _ _
    _ _ _ _ _ _
    _ _ _ _ _ _
    _ _ _ _ _ _
    depends on difficulty.

    */

    board.fillBoard();
    board.calculateNearbyMines();
    board.getBoard()[3][3] = new Tiles(3, 3, true);
    board.getBoard()[1][1] = new Tiles(1, 1, true);
    board.getBoard()[6][6] = new Tiles(6, 6, true);

    while (!board.clickedMine()) {
      System.out.println();
      System.out.println();
      System.out.println(board);
      System.out.println("Format for revealing a Tile: r rowValue colValue ");
      System.out.println("Ex: r 0 0");
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
