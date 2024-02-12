package Score;

import java.awt.*;
import Const.Const;

public class PlayerScore {

    private int score;
    private final int x;
    private final int y;

    public PlayerScore() {
        this.x = Const.SCORE_X;
        this.y = Const.SCORE_Y;
    }

    public void setScore(int score) { this.score = score; }

    public int getScore() { return this.score; }



    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.setFont(Const.SCORE_FONT);
        graphics.drawString("Score: " + this.score, this.x, this.y);
    }

}
