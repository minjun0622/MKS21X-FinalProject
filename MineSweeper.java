import java.util.*;
import java.io.*;

public class MineSweeper {

public static void main(String[] args) {

  /*
  //so we can pick the difficulty
  if (args.length == 0) {
    System.out.println("Please insert the difficulty. There are easy, medium, hard. Have fun.");
  }
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
<<<<<<< HEAD
=======
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
  }
      while (running) {
      long tEnd = System.currentTimeMillis();
      long millis = tEnd - tStart;
      putString(1,2,terminal,"Milliseconds since start of program: "+millis);
      if(millis/1000 > lastSecond){
        lastSecond = millis / 1000;
        //one second has passed.
        putString(1,3,terminal,"Seconds since start of program: "+lastSecond);
      }
    }
  }
}
>>>>>>> ee226e055c701d14736e5a20b728065eae92f018
