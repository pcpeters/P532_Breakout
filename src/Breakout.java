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
//		Bean bean = new Bean();
//		bean.setBx(1000);
//		bean.setBy(100);
//		bean.setPx(900);
//		bean.setPy(930);
//		Image ball = new ImageIcon("C:\\Users\\kshitij\\Desktop\\soccerball.png").getImage();
//		Image paddle = new ImageIcon("C:\\Users\\Connor\\Desktop\\paddle.jpg").getImage();
//		bean.setPaddle(paddle);
//		bean.setBall(ball);
//		
//		BreakoutUI frame = new BreakoutUI();
//		frame.setSize(1920, 1080);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("Breakout!");
//		
//		JPanel panel = new JPanel();
//		panel.setSize(1920, 1080);
//		panel.setBackground(Color.magenta);
//		frame.add(panel);
//		frame.setVisible(true);
//		

		frame = new JFrame("Test Frame");
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		ui = new BreakoutUI(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.getContentPane().add(ui);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
	}
}
