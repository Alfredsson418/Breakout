package Engine;

import Entities.Ball;
import Entities.BoxCollection;
import Entities.Player;
import Const.Const;
import Score.PlayerScore;
import Screens.Pause;

import javax.swing.*;
import java.awt.*;


public class Game {

	Player player;
	Ball ball;
	BoxCollection collection;
	PlayerScore score;

	GameBoard board;





	public Game(GameBoard board) {

		player = new Player(board, Const.PLAYER_WIDTH, Const.PLAYER_HEIGHT);

		ball = new Ball(board, Const.BALL_WIDTH, Const.BALL_HEIGHT);

		collection = new BoxCollection(Const.BOX_ROWS);

		score = new PlayerScore();

		this.board = board;



	}

	public void update(Keyboard keyboard) {
		if (ball.getLives() < 0) {
			JOptionPane.showMessageDialog(board, "No more lives left, sorry :)");
			board.stop();
			return;
		}

		if (collection.isAllDestoryed()) {
			JOptionPane.showMessageDialog(board, "Good job! Your score is " + score.getScore());
			board.stop();
			return;
		}

		player.update(keyboard);
		ball.update(keyboard);
		if (ball.intersects(player)) {
			ball.updateAngle(player);
		}

		int points = collection.update(ball);
		if (points > 0) {
			score.setScore(score.getScore() + points);
			ball.updateSpeed(score.getScore());
		}







	}

	public void draw(Graphics2D graphics) {
		player.draw(graphics);
		ball.draw(graphics);
		collection.draw(graphics);
		score.draw(graphics);
		ball.drawLives(graphics);

	}
}
