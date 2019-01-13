import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;
/*import board.java;
import Tiles.java;
*/

public class MineSweeper {

public static void putString(int r, int c,Terminal t, String s){
  t.moveCursor(r,c);
  for(int i = 0; i < s.length();i++){
    t.putCharacter(s.charAt(x));
  }
}

public static void main(String[] args) {
  int x = 5;
  int y = 5;
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
