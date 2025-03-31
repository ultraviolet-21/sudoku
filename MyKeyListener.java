
import java.awt.event.*;
class MyKeyListener extends KeyAdapter{
  private boolean escPressed;

  public MyKeyListener()
  {
    escPressed = false;
  }
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode()== 27)
            escPressed = true;
    }
  public boolean esc()
    {
    return escPressed;
    }
  
}