package Entities;

import Const.Const;
import Engine.GameBoard;
import Engine.Keyboard;
import Engine.Sprite;


import java.awt.*;
import java.util.Random;

public class Ball extends Sprite {

    private double rads;
    private int speed = Const.BALL_START_SPEED;

    public double generateRandomAngle() {
        Random rand = new Random();
        return rand.nextDouble(2*Math.PI);
    }

    public Ball(GameBoard board, int width, int height) {
        super(0, 0, width, height);

        int x = board.getPreferredSize().width;
        int y = board.getPreferredSize().height;

        // Sets player in the middle
        this.setX(x/2 - getWidth()/2);

        this.setY((int) (y * 0.5));

        // this.rads = 19*Math.PI/180;
        this.rads = generateRandomAngle();

    }

    @Override
    public void update(Keyboard keyboard) {

        if (this.getX() + this.getWidth() > Const.WINDOW_WIDTH) { // Right
            this.rads = Math.PI - this.rads;
            this.setX(Const.WINDOW_WIDTH - this.getWidth());

        } else if (this.getX() < 0) { // Left
            this.rads = Math.PI - this.rads;
            // this.setX(this.getWidth());

        }else if (this.getY() < 0) { // Top
            this.rads = this.rads * -1;
            // this.setY(0);

        } else if (this.getY() + this.getHeight() > Const.WINDOW_HEIGHT) { // Bottom
            System.exit(0);
        }

        double x = Math.cos(rads) * this.speed;
        double y = Math.sin(rads) * this.speed;
        // System.out.println("Ange = " + rads * 180 / Math.PI + "  X = " + x + "  Y = " + y );
        this.setX(getX() + (int)x);

        // Negative because y0 is at top
        this.setY(getY() - (int)y);


    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    public void updateAngle(Sprite obj) {

        Rectangle top = new Rectangle(obj.getX(), obj.getY(), obj.getWidth(), 1);
        Rectangle bottom = new Rectangle(obj.getX(), obj.getY() + obj.getHeight(), obj.getWidth(), 1);

        // the sides are not the height of the rect, just because we do not want some unwanted behavior because the sides are checked first in the program
        // If the sides are the height of the rects reacts on the sides of the top and bottom sides of the object
        Rectangle left = new Rectangle(obj.getX(), obj.getY() + obj.getHeight() / 3, 1, obj.getHeight() / 3);
        Rectangle right = new Rectangle(obj.getX() + obj.getWidth(), obj.getY() + obj.getHeight() / 3, 1, obj.getHeight() / 3);

        Rectangle BallObj = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());

         if (BallObj.intersects(left)) {
            this.rads = Math.PI - this.rads;

            /*
            // 180 degrees and higher
            if (this.rads > Math.PI) {
                this.rads = 3 * Math.PI - this.rads;
            } else if (this.rads < Math.PI) {
                this.rads = Math.PI - this.rads;
            }

             */

            this.setX(obj.getX() - this.getWidth() - 1);

        } else if (BallObj.intersects(right)) {

            this.rads = Math.PI - this.rads;

            /*

            if (this.rads > Math.PI) {
                this.rads = 3 * Math.PI - this.rads;
            } else if (this.rads < Math.PI) {
                this.rads = Math.PI - this.rads;
            }

            this.setX(obj.getX() + obj.getWidth() + 1);

             */

            this.setX(obj.getX() + obj.getWidth() + 1);

        } else if (BallObj.intersects(top)) {
            this.rads = this.rads * -1;
            this.setY(obj.getY() - this.getHeight());

        } else if (BallObj.intersects(bottom)) {
            this.rads = this.rads * -1;
            this.setY(obj.getY() + this.getHeight());

        }



    }

    public void updateSpeed(int score) {
        if (score % 10 == 0) {
            this.speed += 2;
        }

    }


}
