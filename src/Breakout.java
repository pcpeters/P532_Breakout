import javax.swing.JFrame;

public class Breakout extends JFrame 
{
	public static void main(String[] ar)
	{		
		JFrame frame = new JFrame("Breakout!");
		frame.setSize(1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		BreakoutUI breakoutUI = new BreakoutUI();
		Breakout breakout = new Breakout();
		breakout.add(breakoutUI);
	}
}
