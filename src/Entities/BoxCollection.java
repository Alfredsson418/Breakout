package Entities;

import Const.Const;

import java.awt.*;
import java.util.ArrayList;

public class BoxCollection {

    public ArrayList<Box> collection;

    public BoxCollection() {
        collection = new ArrayList<>(100);
        this.resetBoxes();

    }

    private void resetBoxes() {

        this.collection.clear();

        for (int i = 2; i < Const.BOX_ROWS + Const.EMPTY_ROWS; i++) {
            for (int j = 0; j < Const.BOX_PER_ROW; j++) {
                collection.add(j, new Box(j * (Const.BOX_WIDTH + 5), i * (Const.BOX_HEIGHT + 5), Const.BOX_WIDTH, Const.BOX_HEIGHT , Const.BOX_ROWS + Const.EMPTY_ROWS - i));
            }
        }
    }



    public int update(Ball ball) {
        int hits = 0;
        for ( Box box : collection) {
            if (box.isDestroyed) { continue; }

            if (box.intersects(ball)) {
                ball.updateAngle(box);
                if (box.lives == 1) {
                    box.isDestroyed = true;
                }
                box.lives -= 1;
                hits++;
            }
        }
        return hits;
    }

    public void draw(Graphics2D graphics) {
        for (Box box : collection) {
            if (box.isDestroyed) { continue; }
            box.draw(graphics);
        }
    }

    public boolean isAllDestoryed() {
        for (Box box : collection) {
            if (!box.isDestroyed) {
                return false;
            }
        }

        return true;
    }

    public void reset() {
        this.resetBoxes();
    }


}
