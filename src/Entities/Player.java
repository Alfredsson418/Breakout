package Entities;

import Engine.GameBoard;
import Engine.Key;
import Engine.Keyboard;
import Engine.Sprite;
import Const.Const;

import java.awt.*;

public class Player extends Sprite {

    public Player(GameBoard board, int width, int height) {
        super(0, 0, width, height);
        int x = board.getPreferredSize().width;
        int y = board.getPreferredSize().height;

        // Sets player in the middle
        setX(x/2 - getWidth()/2);

        setY((int) (y * 0.85));
    }

    @Override
    public void update(Keyboard keyboard) {
        int speed;
        if (keyboard.isKeyDown(Key.Shift)) { speed = Const.PLAYER_SPEED_BOOST; } else { speed = Const.PLAYER_SPEED; }
        if (keyboard.isKeyDown(Key.Right)) { this.setX(this.getX() + speed); }
        if (keyboard.isKeyDown(Key.Left)) { this.setX(this.getX() - speed); }

        if (this.getX() < 0) {
            this.setX(0);
        }
        if (this.getX() + this.getWidth() > Const.WINDOW_WIDTH) {
            this.setX(Const.WINDOW_WIDTH - this.getWidth());
        }

    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());

    }



}
