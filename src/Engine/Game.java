package Engine;

import Entities.Ball;
import Entities.BoxCollection;
import Entities.Player;
import Const.Const;
import Score.PlayerScore;

import java.awt.*;


public class Game {

	Player player;
	Ball ball;
	BoxCollection collection;
	PlayerScore score;




	public Game(GameBoard board) {

		player = new Player(board, Const.PLAYER_WIDTH, Const.PLAYER_HEIGHT);

		ball = new Ball(board, Const.BALL_WIDTH, Const.BALL_HEIGHT);

		collection = new BoxCollection(Const.BOX_ROWS);

		score = new PlayerScore(10, 10);

	}

	public void update(Keyboard keyboard) {
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

	}
}
