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
	private static int ballX = 0, ballY = 0, key = 0;
	
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
		repaint();
		notifyObservers();
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
