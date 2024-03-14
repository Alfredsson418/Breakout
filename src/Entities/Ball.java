package Entities;

import Const.Const;
import Engine.Keyboard;
import Engine.Sprite;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite {

    private double rads;
    private int speed = Const.BALL_START_SPEED;

    private int lives = Const.BALL_START_LIVES;


    public Ball() {
        super(0, 0, Const.BALL_WIDTH, Const.BALL_HEIGHT);

        // Sets player in the middle
        this.setX(Const.BALL_START_X);
        this.setY(Const.BALL_START_Y);

        this.rads = generateRandomAngle();

    }

    public double generateRandomAngle() {
        Random rand = new Random();
        double rad = rand.nextDouble(Math.PI);

        while (rad > 2.8 || rad < 0.34) {
            rad = rand.nextDouble(Math.PI);
        }

        return rad;
    }

    @Override
    public void update(Keyboard keyboard) {
        if (this.rads > 2 * Math.PI) { this.rads -= 2 * Math.PI; }

        if (this.getX() + this.getWidth() > Const.WINDOW_WIDTH) { // Right
            this.rads = Math.PI - this.rads;
            this.setX(Const.WINDOW_WIDTH - this.getWidth());

        } else if (this.getX() < 0) { // Left
            this.rads = Math.PI - this.rads;
            this.setX(0);

        }else if (this.getY() < 0) { // Top
            this.rads = this.rads * -1;
            this.setY(0);

        } else if (this.getY() + this.getHeight() > Const.WINDOW_HEIGHT) { // Bottom
            this.lives -= 1;
            this.setX(Const.BALL_START_X);
            this.setY(Const.BALL_START_Y);
            this.rads = generateRandomAngle();
        }
        double x = Math.cos(rads) * this.speed;
        double y = Math.sin(rads) * this.speed;

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
            this.setX(obj.getX() - this.getWidth() - 1);

        } else if (BallObj.intersects(right)) {
            this.rads = Math.PI - this.rads;
            this.setX(obj.getX() + obj.getWidth() + 1);

        } else if (BallObj.intersects(top)) {
             if (obj instanceof Player) {
                 double testAngle = Math.PI * ((obj.getWidth() - ((this.getX() + (double) this.getWidth() / 2) - (double) obj.getX())) / obj.getWidth());
                 if (testAngle > 2.99 && testAngle < 3.29) {
                     testAngle += 0.15;
                 }
                 this.rads = testAngle;
             } else {
                 this.rads = this.rads * -1;
             }

             this.setY(obj.getY() - this.getHeight());

        } else if (BallObj.intersects(bottom)) {
            this.rads = this.rads * -1;
            this.setY(obj.getY() + this.getHeight());

        }
    }

    public void updateSpeed(int score) {
        // This does not really work well with collisions
        if (score % Const.TEN == 0) {
            this.speed++;
        }
    }



    public void drawLives(Graphics2D graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.setFont(Const.SCORE_TITLE_FONT);
        graphics.drawString("Lives: " + this.lives, Const.BALL_LIVES_X, Const.BALL_LIVES_Y);
    }

    public int getLives() {
        return this.lives;
    }

    public void setLives(int lives) { this.lives = lives; }

    public void reset() {
        this.setX(Const.BALL_START_X);
        this.setY(Const.BALL_START_Y);
    }


}
