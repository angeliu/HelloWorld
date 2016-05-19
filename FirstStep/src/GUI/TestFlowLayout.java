package GUI;

import java.awt.*;

public class TestFlowLayout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("FlowLayout");
		Button button1 = new Button("OK");
		Button button2 = new Button("close");
		Button button3 = new Button("open");
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		f.add(button1);
		f.add(button2);
		f.add(button3);
		f.setSize(100,100);
		f.setVisible(true);
		
		
		
		


	}

}
