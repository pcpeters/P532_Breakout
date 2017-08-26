import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BreakoutUI extends JPanel implements Constants, Subject, Runnable {
	
	private List<Observer> observers;
	//private Bean bean = new Bean();
	public void notifyObservers() {
		for (Observer observer: observers) {
			observer.update(5);
		}
	}
	//private static int ballX = 0, ballY = 0, key = 0;
	
	private Ball ball;
	private Paddle paddle;
	private Thread game;
	
	public BreakoutUI(int width, int height ){
		setBackground(Color.GREEN);
		paddle = new Paddle(PADDLE_X_START, PADDLE_Y_START, PADDLE_WIDTH,
                PADDLE_HEIGHT, Color.BLACK);
        ball = new Ball(BALL_X_START, BALL_Y_START, BALL_WIDTH, BALL_HEIGHT,
                Color.BLACK);
        observers = new ArrayList<Observer>();
        register(ball);
        game = new Thread(this);
        game.start();
        //System.out.println(observers.size());
	}
	
	BreakoutUI(Bean b)
	{
		//bean = b;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		paddle.draw(g);
		ball.draw(g);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			
			int x = ball.getX();
            int y = ball.getY();
            
            int w = getWidth();
            int bw = ball.getWidth();
            
            //System.out.print("Component width - "+w+" ball width - "+bw);
            //System.out.println("xdir = "+ball.getxDir());
            checkWall(x, y);
            checkPaddle(x, y);
            
			repaint();
			notifyObservers();
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	 private void checkWall(int x, int y) {
		 
		 if(getWidth() > 0){
			//Right wall		 
			 if (x >= getWidth() - ball.getWidth()) {	
		         ball.setxDir(-1);
			 }
			 
			 //Left wall
			 if (x <= 0) {
		         ball.setxDir(1);
		     }
			 
			 //Top
		     if (y <= 0) {
		    	 ball.setyDir(1);
		     }
		         
		     //Bottom
		     if (y >= getHeight()) {
		    	 ball.setyDir(-1);
		     }			 
		 }		 
	 }
	 
	 public void checkPaddle(int x, int y){		
		 
		 if((x >= paddle.getX()) && (x <= (paddle.getX() + paddle.getWidth()))
				 && ((y >= paddle.getY())) && (y <= (paddle.getY() + paddle.getHeight()))){
			 
			 ball.setyDir(-1);
		 }
		 
		 //To ensure paddle is bound by the frame
		 if(paddle.getX() <=0) {
			 paddle.setX(x);
		 }
		 
		 if (paddle.getX() + paddle.getWidth() >= getWidth()) {
	         paddle.setX(getWidth() - paddle.getWidth());
	     }
	 }

	@Override
	public void register(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}
	

	@Override
	public void notifyObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver() {
		// TODO Auto-generated method stub
		
	}
}
