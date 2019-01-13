
public class MineSweeper {
  int seed;

  public String displayTime() {
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
public static void putString(int r, int c,Terminal t, String s){
  t.moveCursor(r,c);
  for(int i = 0; i < s.length();i++){
    t.putCharacter(s.charAt(x));
  }
}
public static void main(String[] args) {
  }
  //so we can pick the difficulty
  if (args.length == 0) {
    System.out.println("Please insert the difficulty. There are easy, medium, hard. Have fun.");
  }
  if (args.length == 1) {
    //start game with intended difficulty.
    if (args[2].equals("easy")) {
      int x = 5;
      int y = 5;

    }

  }

}





}
