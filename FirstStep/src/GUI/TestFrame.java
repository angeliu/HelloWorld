package GUI;

import java.awt.*;

public class TestFrame 
{
	public static void main(String[] args)
	{
		Frame f = new Frame("My First Test");
		f.setLocation(300, 300);
		f.setSize(170,100);
		f.setBackground( Color.BLACK);
		f.setResizable(false);
		f.setVisible(true);
	}

}
