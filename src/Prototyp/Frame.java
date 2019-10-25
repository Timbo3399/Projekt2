package Prototyp;

import javax.swing.JFrame;

public class Frame extends JFrame
{
  // ...ok...
  private static final long serialVersionUID = 2L;

  private Panel panel = null;	

  public Frame()
  { this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setSize(1000,800);
	this.setResizable(false);
	this.setTitle("Prototyp");
	panel = new Panel();
	this.setContentPane(panel);
  }
  
  public Panel getPanel() {return panel;}
}
