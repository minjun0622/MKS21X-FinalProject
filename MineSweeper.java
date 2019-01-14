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
<<<<<<< HEAD
  board.display();
  if (board.finished()) {
    System.out.println("You have beat the game. You're a genius!");
=======
    //start game with intended difficulty.
    if (args[1].equals("easy"))
      int x = 5;
      int y = 5;

    if (args[1].equals("medium"))
      int x = 10;
      int y = 10;
    if (args[1].equals("hard"))
      int x = 15;
      int y = 15;
*/
    Terminal terminal = TerminalFacade.createTerminal();
    terminal.enterPrivateMode();

    boolean running = true;

    long tStart = System.currentTimeMillis();
		long lastSecond = 0;

    while(running){

			terminal.moveCursor(x,y);


      Key key = terminal.readInput();

      if (key != null)
      {
      if (key.getKind() == Key.Kind.Escape) {
        terminal.exitPrivateMode();
				System.exit(0);
      }
      if (key.getKind() == Key.Kind.ArrowLeft) {
      	terminal.moveCursor(x,y);
      	terminal.putCharacter(' ');
      	x--;
      	}
      if (key.getKind() == Key.Kind.ArrowRight) {
        terminal.moveCursor(x,y);
      	terminal.putCharacter(' ');
				x++;
  			}
      if (key.getKind() == Key.Kind.ArrowUp) {
    		terminal.moveCursor(x,y);
				terminal.putCharacter(' ');
    		y--;
  			}
  		if (key.getKind() == Key.Kind.ArrowDown) {
      	terminal.moveCursor(x,y);
    		terminal.putCharacter(' ');
    		y++;
  			}
      if (key.getKind() == Key.Kind.NormalKey) {
        if (isMine())
      terminal.putCharacter('x');
      }
    }
>>>>>>> 19241e210a92c0a0343216c348dbaff1d7e52043
  }
  else {
    System.out.println("You have lost. :(");
  }
  scanner.close();

  }
  }
