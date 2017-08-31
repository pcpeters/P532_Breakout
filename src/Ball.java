import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Bean implements Observer{

	private int xDir = 1;
	private int yDir = -1;
	
	public Ball(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, width, height);
		
	}
	
	//Getters and setters
	public int getxDir() {
		return xDir;
	}

	public void setxDir(int xDir) {
		this.xDir = xDir;
	}

	public int getyDir() {
		return yDir;
	}

	public void setyDir(int yDir) {
		this.yDir = yDir;
	}	
	
	//Updates the movement of ball
	@Override
	public void update(int signal){
		x += xDir;
		y += yDir;
		//System.out.println("x:" + x + "y:" + y);
	}	
}
