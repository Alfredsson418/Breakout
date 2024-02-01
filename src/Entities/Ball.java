package Entities;

import Const.Const;
import Engine.GameBoard;
import Engine.Keyboard;
import Engine.Sprite;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite {

    private double rads;
    private double speed = 5;

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

        this.rads = 19*Math.PI/180;

    }

    @Override
    public void update(Keyboard keyboard) {

        if (this.getX() + this.getWidth() > Const.WINDOW_WIDTH) { // Right
            this.rads = Math.PI - this.rads;
            this.setX(Const.WINDOW_WIDTH - this.getWidth());

        } else if (this.getX() < 0) { // Left
            this.rads = Math.PI - this.rads;
            this.setX(this.getWidth());

        }else if (this.getY() <= 0) { // Top
            this.rads = this.rads * -1;
            this.setY(0);

        } else if (this.getY() + this.getHeight() > Const.WINDOW_HEIGHT) { // Bottom
            System.exit(0);
        }

        double x = Math.cos(rads) * speed;
        double y = Math.sin(rads) * speed;
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
        Rectangle left = new Rectangle(obj.getX(), obj.getY(), 1, obj.getHeight());
        Rectangle right = new Rectangle(obj.getX() + obj.getWidth(), obj.getY(), 1, obj.getHeight());

        Rectangle BallObj = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        if (BallObj.intersects(top)) {
            this.rads = this.rads * -1;
            // this.setY(this.getY() - this.getHeight());

        }else if (BallObj.intersects(bottom)) {
            this.rads = this.rads * -1;
            // this.setY(this.getY() + this.getHeight());

        }else if (BallObj.intersects(left)) {
            // 180 degrees and higher
            if (this.rads > Math.PI) {
                this.rads = 3 * Math.PI - this.rads;
            } else if (this.rads < Math.PI) {
                this.rads = Math.PI - this.rads;
            }

            this.setX(obj.getX() + this.getWidth() + 1);

        }else if (BallObj.intersects(right)) {

            if (this.rads > Math.PI) {
                this.rads = 3 * Math.PI - this.rads;
            } else if (this.rads < Math.PI) {
                this.rads = Math.PI - this.rads;
            }

            this.setX(obj.getX() + obj.getWidth() + 1);

        }



    }

    public void setAngle(double angle) {
        this.rads = angle;
    }
    public double getAngle() {
        return this.rads;
    }



}
