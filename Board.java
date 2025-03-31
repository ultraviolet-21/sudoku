// if the user input matches the hardcoded int, the index will be shown
// boolean matched and void method show (call these methods from main)

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Board {
    private Square[][] b1;
    private Square[][] b2;
    private Scanner s;
    private File f;
    private String line;
    private int numLines;
    private String[] parts;
    private int n;

    public Board() throws FileNotFoundException {
      b1 = new Square[9][9];
      b2 = new Square[9][9];
      //fill board by reading file
      n = (int) (Math.random() * 4 + 1);
      f = new File(n+".txt");
      s = new Scanner(f);
      numLines = -1;
      
      while (s.hasNextLine())
        {
          line = s.nextLine();
          numLines++;
          parts = line.split(" ");
          for (int i = 0; i<9; i++)
            {
              b1[numLines][i] = new Square(parts[i]);
            }
        }
    }

    public void copyBoard(String dif) {
      //creates a copy of the board with some indices removed
      
      for (int row = 0; row<9; row++)
        {
          for (int col = 0; col<9; col++)
            {
              b2[row][col] = b1[row][col];
            }
        }

      int y = 1; //number of indices to remove
      if (dif.equals("easy"))
        y = 25;

      if (dif.equals("medium"))
        y = 40;

      if (dif.equals("hard"))
        y = 55;

       for (int x = 0; x<y; x++)
          b2[(int) (Math.random()*9)][(int) (Math.random()*9)].hide();
    }

    
  
    public void displayBoard() {
      //hardcoded numbers, but random indices will not be shown
      // returns new board with hidden indices
      // easy = remove 25 indices
      // medium = remove 40
      // hard = remove 55
      
      

      for (int row = 0; row<b2.length; row++)
        {
          for (int col = 0; col<b2[0].length; col++)
            {
            System.out.print(b2[row][col].toString() + "\t");
              if ((col+1)%3 ==0)
                System.out.print("\t");
            }
          System.out.println();
          if ((row+1)%3 ==0)
            System.out.println();
        }
    }

    public void checkForMatch(int row, int col, int num) { 
      //checks if value entered is correct/ matches value in file
      int n = Integer.parseInt(b1[row][col].getValue());
      if (num==n)
        b2[row][col].show();
      else
        System.out.println("Incorrect value - please try again");
    }

    public boolean isValidIndex(int row, int col){
    if (row<0 || row>8 || col<0 || col>8 || b2[row][col].isShowing())
    {
      System.out.println("Invalid index - please try again");
      return false;
    }
    else
      return true; 

    }

  public boolean allSquaresFilled() {
    //checks if all squares are filled with the correct values
    for (Square[] row: b2)
      {
        for (Square col: row)
          {
            if (!col.isShowing())
            {
              return false;
            }
          }
      }
    return true;
  }
  
}