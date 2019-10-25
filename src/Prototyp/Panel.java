package Prototyp;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import javax.swing.*;

import Prototyp.A_GraphicSystem;

public class Panel extends JPanel implements A_GraphicSystem, A_InputSystem, MouseListener
{
  // ...ok...
  private static final long serialVersionUID = 1L;
  
  
  // UserInput variables
  //
  private boolean newInput = false;
  private int     mousePressedX, mousePressedY, 
                  mouseMovedX, mouseMovedY, mouseButton;
  private char    keyPressed;
	
  // GraphicsSystem variables
  //
  private GraphicsConfiguration graphicsConf = 
    GraphicsEnvironment.getLocalGraphicsEnvironment().
    getDefaultScreenDevice().getDefaultConfiguration();
  private BufferedImage imageBuffer;
  private Graphics      graphics;
	
  // Graphic variables for drawing
  //
  private static final Color COLOR_DOT  = Color.black;
  private static final int   RADIUS_DOT = 20;
	
  public Panel()
  { 
	this.setSize(1000,800);  
	imageBuffer = graphicsConf.createCompatibleImage(
			        this.getWidth(), this.getHeight());	 
	graphics = imageBuffer.getGraphics();
	
	// initialize Listeners
	this.addMouseListener(this);
  }
  
  public void clear()
  { graphics.setColor(Color.LIGHT_GRAY);
    graphics.fillRect(0, 0, 1000, 800);
  }
  
  public void draw(A_GameObject dot)
  {
	Wall wall1 = new Wall(50, 50, 50, 500);   
	Wall wall2 = new Wall(50, 500, 50, 50); 
	Wall wall3 = new Wall(50, 500, 500, 500); 
	//Wall wall4 = new Wall(500, 500, 500, 500); 
	  
	int x = (int)dot.x-RADIUS_DOT;
	int y = (int)dot.y-RADIUS_DOT;
	int r = RADIUS_DOT*2;
	
	graphics.setColor(COLOR_DOT);
	graphics.fillOval(x, y, r, r);
	graphics.setColor(Color.BLACK);
	graphics.drawOval(x,y,r,r);
	wall1.draw(graphics);
	wall2.draw(graphics);
	wall3.draw(graphics);
	//wall4.draw(graphics);
  }
  
  
  public void redraw()
  { this.getGraphics().drawImage(imageBuffer, 0, 0, this);
  }
  
  
  public void mousePressed(MouseEvent evt)
  {
	// an input Event occurs
	newInput = true;
	
    mousePressedX = evt.getX();
    mousePressedY = evt.getY();
    mouseButton   = evt.getButton();  
  }  
  
  
  public UserInput getUserInput()
  { 
    if(!newInput) return null;
    
    newInput = false;
    return new UserInput(mousePressedX,mousePressedY, 
	  	                   mouseMovedX,mouseMovedY,mouseButton,keyPressed);
  }
  
  
  // direct the Avatar
  public void command(A_GameObject av, UserInput input)
  {
    Player avatar = (Player)av;
    avatar.setDestination(input.mousePressedX, input.mousePressedY);    
  }

  
  public void mouseEntered(MouseEvent evt){}
  public void mouseExited(MouseEvent evt){}
  public void mouseClicked(MouseEvent evt){}
  public void mouseReleased(MouseEvent evt){}
}
