import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class BreakoutUI extends JFrame {
	
	private Bean bean = new Bean();
	private static int ballX = 0, ballY = 0, key = 0;
	
	BreakoutUI(){
		
	}
	
	BreakoutUI(Bean b)
	{
		bean = b;
	}
	
	public void paintComponents(Graphics g)
	{
		super.paintComponents(g);
		ballX = bean.getBx();
		ballY = bean.getBy();
		g.drawImage(bean.getBall(), ballX, ballY, this);
		System.out.println(ballX);
	}
}
