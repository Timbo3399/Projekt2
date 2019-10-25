package Prototyp;

public class World
{
  private A_GraphicSystem graphicSystem;
  private A_InputSystem    inputSystem;
  
  private UserInput userInput;
  
  private Player userDot;
  
  private Wall wall;
  
  public void init()
  {
	userDot = new Player(500,400);
	wall = new Wall(50, 50, 50, 500);   
	wall = new Wall(50, 500, 50, 50); 
	wall = new Wall(50, 500, 500, 500);
  }
  
  public void run()
  {
	long lastTick = System.currentTimeMillis();
	while(true)
	{
	  // calculate elapsed time
	  //
	  long currentTick    = System.currentTimeMillis();
	  double diffSeconds  = (currentTick-lastTick)/1000.0;
	  lastTick            = currentTick;
	  
	  // parse User Input
	  userInput = inputSystem.getUserInput();
	  if(userInput!=null)
	  { inputSystem.command(userDot, userInput);
	  }
	  
	  try{ Thread.sleep(50); } catch(Exception ex){}
	  
	  userDot.move(diffSeconds);
	  graphicSystem.clear();
	  graphicSystem.draw(userDot);
	  graphicSystem.redraw();
	  
	  
	}
  }
  
  
  public void setGraphicSystem(A_GraphicSystem p) { graphicSystem = p; }
  public void setInputSystem(A_InputSystem p)     { inputSystem   = p; }
}
