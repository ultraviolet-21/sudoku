// this is the game runner
//user can choose difficulty - if harder, then more indices will be removed
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

class Main {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println("Hello world!");
    Scanner in = new Scanner(System.in);
   /* KeyEvent k = new KeyEvent(frame,
        KeyEvent.KEY_TYPED, 10, 0, KeyEvent.VK_ENTER); */
    JFrame jf = new JFrame("title");
    MyKeyListener k = new MyKeyListener();
  jf.addKeyListener(k);
  jf.setVisible(false);
    System.out.println("Choose a difficulty: easy, medium, or hard");
    String str = in.next();
    Board b = new Board(); 
    b.copyBoard(str); //this will fill the board with the numbers from the file
   
    while (!b.allSquaresFilled)) {
    b.displayBoard();
    System.out.println("Enter the index you want to fill (or press esc to quit): ");
    int row = in.nextInt();
    int col = in.nextInt();

    if (b.isValidIndex(row, col))
    {
      System.out.println("Enter a value 1-9: ");
      int num = in.nextInt();
      b.checkForMatch(row, col, num);
    }

     if (k.esc())
      {
        System.out.println("Quit game");
        break;
      }

    }
      

    if (b.allSquaresFilled()) {
      b.displayBoard();
      System.out.println("You win!");
      }
    in.close();
  }

  
}