package Entities;

import java.awt.*;
import java.util.ArrayList;

public class BoxCollection {

    public ArrayList<Box> collection;

    private int boxHeigth = 20;
    private int boxWidth = 40;
    public BoxCollection(int rows) {
        collection = new ArrayList<Box>(100);
        for (int i = 2; i < rows + 2; i++) {
            for (int j = 0; j < 14; j++) {
                collection.add(j, new Box((j * (boxWidth + 5)) + boxWidth * 2, i * (boxHeigth + 5), boxWidth, boxHeigth ));
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
