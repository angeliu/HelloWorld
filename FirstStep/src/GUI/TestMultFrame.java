package GUI;

import java.awt.*;

public class TestMultFrame 
{
	public static void main(String[] args)
	{
		MyFrame f1 = new MyFrame(100,100,200,200,Color.blue);
		MyFrame f2 = new MyFrame(300,100,200,200,Color.yellow);
		
	}
	
	public static void main(String[] args,int intput) {
		
	}
	

	

}

class MyFrame extends Frame
{
	
	static int id = 0;
	MyFrame(int x,int y, int w,int h,Color color)
	{
		super("MyFrame " + (++id));
		setBackground(color);
		setLayout(null);
		setBounds(x,y,w,h);
		setVisible(true);
	}
}