import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Breakout implements Constants
{
	private static JFrame frame;
	private static BreakoutUI ui;
	
	public static void main(String[] ar)
	{	

		frame = new JFrame("Breakout: The Beginnings");
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		ui = new BreakoutUI(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.getContentPane().add(ui);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
	}
}
