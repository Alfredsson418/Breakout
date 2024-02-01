package Entities;

import Engine.Keyboard;
import Engine.Sprite;

import java.awt.*;

public class Box extends Sprite {

    public boolean isDestroyed = false;

    public Box(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    @Override
    public void update(Keyboard keyboard) {

    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void remove(){

    }

}
