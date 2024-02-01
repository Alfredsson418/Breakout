package Engine;

import Entities.Ball;
import Entities.BoxCollection;
import Entities.Player;

import java.awt.*;


public class Game {

	Player player;
	Ball ball;

	BoxCollection collection;



	public Game(GameBoard board) {

		player = new Player(board, 150, 20);

		ball = new Ball(board, 15, 15);

		collection = new BoxCollection(6);

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
