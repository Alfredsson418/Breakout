package Entities;

import Engine.GameBoard;
import Engine.Key;
import Engine.Keyboard;
import Engine.Sprite;

import java.awt.*;

public class Player extends Sprite {

    private int speed;
    public Player(GameBoard board, int width, int height) {
        super(0, 0, width, height);
        int x = board.getPreferredSize().width;
        int y = board.getPreferredSize().height;

        // Sets player in the middle
        setX(x/2 - getWidth()/2);

        setY((int) (y * 0.9));
    }

    @Override
    public void update(Keyboard keyboard) {
        if (keyboard.isKeyDown(Key.Shift)) { this.speed = 8; } else { this.speed = 4; }
        if (keyboard.isKeyDown(Key.Right)) { this.setX(this.getX() + this.speed); }
        if (keyboard.isKeyDown(Key.Left)) { this.setX(this.getX() - this.speed); }

    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());

    }


}
