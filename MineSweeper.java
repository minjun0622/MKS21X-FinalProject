import java.util.*;
import java.io.*;

public class MineSweeper {
  public static void main(String[] args) {


    Scanner scanner = new Scanner(System.in);

    //start game with intended difficulty.

    Board board = new Board();
    if (args.length == 0) {
      System.out.println("Please insert the difficulty. There are easy, medium, hard. Have fun.");
    }
    else {
      if (args[0].equals("easy"))
        board = new Board(5, 5);

      if (args[0].equals("medium"))
        board = new Board(10, 10);

      if (args[0].equals("hard"))
        board = new Board(15, 15);
      }

    /*
    _ _ _ _ _ _
    _ _ _ _ _ _
    _ _ _ _ _ _
    _ _ _ _ _ _
    _ _ _ _ _ _
    _ _ _ _ _ _
    depends on difficulty.
    */



    board.getBoard()[3][3] = new Tiles(3, 3, true);
    board.getBoard()[1][1] = new Tiles(1, 1, true);
    board.fillBoard();
    board.calculateNearbyMines();
    board.calculateNumMines();
    board.calculateMinedTiles();
    //board.getBoard()[6][6] = new Tiles(6, 6, true);

    while (!board.exited() && !board.clickedMine() && !board.boardComplete()) {
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
    if (board.clickedMine()) {
      System.out.println();
      System.out.println();
      System.out.println(board);
      System.out.println("You revealed a mine.");
      scanner.close();
    }
    else if (board.exited()) {
      System.out.println();
      System.out.println();
      System.out.println(board);
      System.out.println("You exited.");
      scanner.close();
    }
    else {
      System.out.println();
      System.out.println();
      System.out.println(board);
      System.out.println("You won!");
      scanner.close();
    }
  }
}
