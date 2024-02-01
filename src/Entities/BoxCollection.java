package Entities;

import java.awt.*;
import java.util.ArrayList;
import Const.Const;

public class BoxCollection {

    public ArrayList<Box> collection;

    public BoxCollection(int rows) {
        collection = new ArrayList<>(100);
        for (int i = 2; i < rows + 2; i++) {
            for (int j = 0; j < Const.BOX_PER_ROW; j++) {
                collection.add(j, new Box((j * (Const.BOX_WIDTH + 5)) + Const.BOX_WIDTH * 2, i * (Const.BOX_HEIGHT + 5), Const.BOX_WIDTH, Const.BOX_HEIGHT ));
            }
        }

    }

    public void update(Ball ball) {
        for ( Box box : collection) {
            if (box.isDestroyed) { continue; }

            if (box.intersects(ball)) {
                ball.updateAngle(box);
                box.isDestroyed = true;
            }
        }
    }

    public void draw(Graphics2D graphics) {
        for (Box box : collection) {
            if (box.isDestroyed) { continue; }
            box.draw(graphics);
        }
    }


}
