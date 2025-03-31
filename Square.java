public class Square {
  private boolean isShowingValue;
  private String value;
  private String hidden;

  public Square (String v) {
    value = v;
    isShowingValue = true;
    hidden = "_";
  }

  public void show()
  {
    isShowingValue = true;
  }

  public void hide()
  {
    isShowingValue = false;
  }
  
  public String getValue() {return value;}
  
  public String toString()
  {
    if (isShowingValue)
      return value;
    else
      return hidden;
  }

  public boolean isShowing()
  {
    return isShowingValue;
  }
}