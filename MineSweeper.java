
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

public static void main(String[] args) {
  if (args.length == 0) {
    System.out.println( )
  }

}





}