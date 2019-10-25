package Prototyp;

import java.awt.Graphics;

public class Wall{
	
	 int  destX1;
	 int  destY1;
	 int  destX2;
	 int  destY2;
	  
	  public Wall(int x_, int y_, int y2_,int x2_){
		  destX1 =x_;  
		  destY1 =y_;
		  destY2 =y2_;
		  destX2 =x2_;
	  }
	  
	  public void draw(Graphics g) {
		  g.drawLine(destX1, destY1, destX2, destY2);
	  }
	 
	  

}
