package Entities;

import Engine.Keyboard;
import Engine.Sprite;
import Const.Const;

import java.awt.*;

public class Box extends Sprite {

    public boolean isDestroyed = false;

    public int lives;

    public Box(int x, int y, int width, int height, int lives) {
        super(x, y, width, height);
        this.lives = lives;
    }
    @Override
    public void update(Keyboard keyboard) {

    }

    @Override
    public void draw(Graphics2D graphics) {
        Color livesColor = new Color(0 ,255 * (Const.BOX_ROWS - this.lives )/ Const.BOX_ROWS, 255); // Color white

        graphics.setColor(livesColor);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }


}
