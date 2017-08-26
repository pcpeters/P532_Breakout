import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BreakoutUI extends JPanel implements Constants, Subject, Runnable {
	
	private List<Observer> observers;

	public void notifyObservers() {
		for (Observer observer: observers) {
			observer.update(5);
		}
	}
	
	private Ball ball;
	private Paddle paddle;
	private Brick[][] brick = new Brick[BRICK_COLUMNS][BRICK_ROWS];
	
	private Thread game;
	
	public BreakoutUI(int width, int height ){
		super.setSize(width, height);
		
		addKeyListener(new BreakoutUIListener());
		setFocusable(true);
		
		setBackground(Color.GREEN);
		
		paddle = new Paddle(PADDLE_X_START, PADDLE_Y_START, PADDLE_WIDTH,
                PADDLE_HEIGHT, Color.BLACK);
		
        ball = new Ball(BALL_X_START, BALL_Y_START, BALL_WIDTH, BALL_HEIGHT,
                Color.BLACK);
        
        makeBricks();        
        
        observers = new ArrayList<Observer>();
        register(ball);
        game = new Thread(this);
        game.start();
        //System.out.println(observers.size());
	}
	
	// Fills the array of bricks
    private void makeBricks() {
        for (int i = 0; i < BRICK_COLUMNS; i++) {
            for (int j = 0; j < BRICK_ROWS; j++) {
                brick[i][j] = new Brick((i * BRICK_WIDTH),
                        ((j * BRICK_HEIGHT) + (BRICK_HEIGHT / 2)),
                        BRICK_WIDTH - 5, BRICK_HEIGHT - 5, Color.gray);
            }
        }
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
		
		for (int i = 0; i < BRICK_COLUMNS; i++) {
            for (int j = 0; j < BRICK_ROWS; j++) {
                brick[i][j].draw(g);
            }
        }		
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
            brickCollisionCheck(x, y);
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
	 
	 private void brickCollisionCheck(int x, int y) {
		 for (int i=0; i<BRICK_COLUMNS;i++) {
			 for (int j=0; j<BRICK_ROWS; j++) {
				 if (brick[i][j].bottomCollision(x, y)) {
					 ball.setyDir(1);
				 }
				 if (brick[i][j].leftCollision(x, y)) {
					 ball.setxDir(-1);
				 }
				 if (brick[i][j].rightCollision(x, y)) {
					 ball.setxDir(1);
				 }
				 if (brick[i][j].topCollision(x, y)) {
					 ball.setyDir(-1);
				 }
			 }
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
	
	private class BreakoutUIListener extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent ke) {
			int key = ke.getKeyCode();
			System.out.print(key);
			if (key == 37) {
				paddle.setX(paddle.getX() - 50);
			}
			
			if (key == 39) {
				paddle.setX(paddle.getX() + 50);
			}
		}
	}
	
}
