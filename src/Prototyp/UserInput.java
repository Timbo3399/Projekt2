package Prototyp;

public class UserInput 
{
  // everything a user can press on keyboard or mouse
  public int  mousePressedX, mousePressedY, 
              mouseMovedX, mouseMovedY, mouseButton;
  public char keyPressed;
  
  // ... is returned as a data set
  public UserInput(int mpx,int mpy,int mmx,int mmy,int mb,char kp)
  { mousePressedX=mpx;  mousePressedY=mpy; 
    mouseMovedX  =mmx;  mouseMovedY  =mmy;
    mouseButton  =mb;  
    keyPressed   =kp;
  }
}

