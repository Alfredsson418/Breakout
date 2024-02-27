package Engine;

import Const.Const;
import Score.ScoreBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameBoard extends JPanel {
	private final int FPS = 40; 
	private Game game;
	private Keyboard keyboard;


	private boolean stop = false;
	public GameBoard() {
		keyboard = new Keyboard();
		game = new Game(this);

	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D graphics = (Graphics2D)arg0;
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, getWidth(), getHeight());

		Toolkit.getDefaultToolkit().sync();
		
		game.draw(graphics);
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		if (e.getID() == KeyEvent.KEY_PRESSED)
			keyboard.processKeyEvent(e.getKeyCode(), true);
		else if (e.getID() == KeyEvent.KEY_RELEASED)
			keyboard.processKeyEvent(e.getKeyCode(), false);
	}

	public void start() {
		while(!stop) {
			game.update(keyboard);
			try {
				Thread.sleep(1000 / FPS); //Throttle thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}

	public void stop() {
		this.stop = true;
	}

    public void restart() {
        this.game.getBall().setLives(Const.BALL_START_LIVES);
        this.game.getScoreBoard().getCurrentScore().setScore(0);
        this.game.getBall().reset();
		this.game.getCollection().reset();
    }

	public void setScoreBoard(ScoreBoard scoreBoard) {
		game.setScoreBoard(scoreBoard);
	}
}
