package Engine;

import Const.Const;
import Entities.Ball;
import Entities.BoxCollection;
import Entities.Player;
import Score.ScoreBoard;

import javax.swing.*;
import java.awt.*;


public class Game {

	private Player player;

    private Ball ball;

	private BoxCollection collection;

	private GameBoard board;

	private ScoreBoard scoreBoard;





	public Game(GameBoard board) {

		player = new Player(board);

		ball = new Ball();

		collection = new BoxCollection();

		this.board = board;

	}

	public void update(Keyboard keyboard) {
		if (ball.getLives() < 0) {
			String initials = JOptionPane.showInputDialog("Good work! Put in your initials to save your score!");
			while (initials.length() < Const.INITIALS_LENGTH){
				initials = JOptionPane.showInputDialog("Good work! Put in your initials to save your score!");
			}
			initials = initials.substring(0, Const.INITIALS_LENGTH);
			scoreBoard.getCurrentScore().setInitials(initials);

            scoreBoard.addCurrentScore();
			board.restart();
			return;
		}

		if (collection.isAllDestoryed()) {
			JOptionPane.showMessageDialog(board, "Good job! Your score is " + scoreBoard.getCurrentScore());
            scoreBoard.addCurrentScore();
			board.restart();
			return;
		}

		player.update(keyboard);
		ball.update(keyboard);
		if (ball.intersects(player)) {
			ball.updateAngle(player);
		}

		int points = collection.update(ball);
		if (points > 0) {
			scoreBoard.getCurrentScore().setScore(scoreBoard.getCurrentScore().getScore() + points);
			ball.updateSpeed(scoreBoard.getCurrentScore().getScore());
		}

        scoreBoard.update();


	}

	public void draw(Graphics2D graphics) {
		player.draw(graphics);
		ball.draw(graphics);
		collection.draw(graphics);
		ball.drawLives(graphics);
		scoreBoard.drawCurrentScore(graphics);

	}

	public void setScoreBoard(ScoreBoard scoreBoard) {
		this.scoreBoard = scoreBoard;
	}

    public Player getPlayer() {
        return player;
    }

    public Ball getBall() {
        return ball;
    }

    public BoxCollection getCollection() {
        return collection;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public GameBoard getBoard() {
        return board;
    }
}
