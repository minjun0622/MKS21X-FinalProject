import java.util.*;
import java.io.*;

public class MineSweeper {
  public static void main(String[] args) {

    //start game with intended difficulty.
    Board board = new Board();
    if (args.length == 0) {
      System.out.println("Please insert the difficulty. There are easy, medium, hard. Have fun.");
    }
    else {
      if (args[0].equals("easy"))
        board = new Board(6, 6, 10);
        //6 by 6 board and each tile has
        //10% chance of being a mine.

      if (args[0].equals("medium"))
        board = new Board(8, 8, 15);
        //8 by 8 board and each tile has
        //15% chance of being a mine.

      if (args[0].equals("hard"))
        board = new Board(10, 10, 20);
        //10 by 10 board and each tile has
        //20% chance of being a mine.
      }

    Scanner scanner = new Scanner(System.in);

    /*
    _ _ _ _ _ _
    _ _ _ _ _ _
    _ _ _ _ _ _
    _ _ _ _ _ _
    _ _ _ _ _ _
    _ _ _ _ _ _
    depends on difficulty.
    a sample look at how the board will look like.
    */

    /*
    board.getBoard()[3][3] = new Tile(3, 3, true);
    board.getBoard()[1][1] = new Tile(1, 1, true);
    This process was used to run the game because placeMines did not work.
    This is not needed anymore.
*/
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
      System.out.println("Oh darn! You revealed a mine.");
      //Losing message.
      scanner.close();
    }
    else if (board.exited()) {
      System.out.println();
      System.out.println();
      System.out.println(board);
      System.out.println("You exited. Goodbye");
      //message when you exit
      scanner.close();
    }
    else {
      System.out.println();
      System.out.println();
      System.out.println(board);
      System.out.println("You won! Do you want a cookie?");
      //winning message
      scanner.close();
    }
  }
}
