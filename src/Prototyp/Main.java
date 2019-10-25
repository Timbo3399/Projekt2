package Prototyp;

public class Main 
{
  private World world = null;
  
  public Main()
  { 
	Frame frame = new Frame();
    frame.setVisible(true);
    
    world = new World();
    world.setGraphicSystem(frame.getPanel());
    world.setInputSystem(frame.getPanel());
    world.init();
    world.run();
  }
	
  public static void main(String[] args)
  { new Main();
  }
}
