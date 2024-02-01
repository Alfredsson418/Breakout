package Engine;

import Entities.Ball;
import Entities.BoxCollection;
import Entities.Player;
import Const.Const;

import java.awt.*;


public class Game {

	Player player;
	Ball ball;
	BoxCollection collection;



	public Game(GameBoard board) {

		player = new Player(board, Const.PLAYER_WIDTH, Const.PLAYER_HEIGHT);

		ball = new Ball(board, Const.BALL_WIDTH, Const.BALL_HEIGHT);

		collection = new BoxCollection(Const.BOX_ROWS);

	}

	public void update(Keyboard keyboard) {


		player.update(keyboard);
		ball.update(keyboard);
		if (ball.intersects(player)) {
			ball.updateAngle(player);
		}

		collection.update(ball);

	}

	public void draw(Graphics2D graphics) {
		player.draw(graphics);
		ball.draw(graphics);
		collection.draw(graphics);
	}
}
