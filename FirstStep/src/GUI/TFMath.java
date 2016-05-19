package GUI;

import java.awt.*;
import java.awt.event.*;

public class TFMath 
{
	public static void main(String[] args)
	{
		new TFFrame1().launchFrame();
		
		
	}

}

class TFFrame1 extends Frame {
	TextField num1, num2, num3;

	public void launchFrame() {

		num1 = new TextField(10);
		num2 = new TextField(10);
		num3 = new TextField(15);
		Label lblPlus = new Label("+");
		Button btnEqual = new Button("=");
		btnEqual.addActionListener(new MyMonitor(this));
		setLayout(new FlowLayout());
		add(num1);
		add(lblPlus);
		add(num2);
		add(btnEqual);
		add(num3);
		pack();
		setVisible(true);
		
		
	}
}

class MyMonitor implements ActionListener {
	TFFrame1 tf = null;

	public MyMonitor(TFFrame1 tf) {
		this.tf = tf;
	}

	public void actionPerformed(ActionEvent e) {
		int n1 = Integer.parseInt(tf.num1.getText());
		int n2 = Integer.parseInt(tf.num2.getText());
		tf.num3.setText("" + (n1 + n2));
	}
}
