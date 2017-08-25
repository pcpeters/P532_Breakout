import java.awt.Color;
import java.awt.Graphics;

public class Brick extends Bean{

	private boolean destroyed;
	
	public Brick(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		setDestroyed(false);
	}
	
	public void draw(Graphics g) {
		if (!destroyed) {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
	}
	
	public void brickCollision() {
		setDestroyed(true);
	}
	

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	
}
