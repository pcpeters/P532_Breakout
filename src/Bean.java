import java.awt.Image;
import java.io.Serializable;

public class Bean implements Serializable {
	
	private int bx;	//coordinates of ball (x, y)
	private int by;
	private int px;	//coordinates of paddle (x,y)
	private int py;
	private Image ball;
	private Image paddle;
	
	public Bean()
	{
		bx = 0;
		by = 0;
		px = 0;
		py = 0;
	}
	
	int getBx()
	{
		return bx;
	}
	
	int getBy()
	{
		return by;
	}
	
	int getPx()
	{
		return px;
	}
	
	int getPy()
	{
		return py;
	}
	
	Image getBall()
	{
		return ball;
	}
	
	Image getPaddle()
	{
		return paddle;
	}
	
	void setBx(int x)
	{
		bx = x;
	}
	
	void setBy(int y)
	{
		by = y;
	}
	
	void setPx(int x)
	{
		px = x;
	}
	
	void setPy(int y)
	{
		py = y;
	}
	
	void setBall(Image b)
	{
		ball = b;
	}
	
	void setPaddle(Image p)
	{
		paddle = p;
	}
}
