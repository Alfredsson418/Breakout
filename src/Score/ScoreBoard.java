package Score;

import Const.Const;

import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel {

    private PlayerScore currentScore;

    private HighScore highScore;

    private LastestRunScore lastestRunScore;


    public ScoreBoard() {

        currentScore = new PlayerScore();


        this.setLayout(new GridLayout(2, 0));
        


        this.highScore = new HighScore();
        this.add(highScore);

        this.lastestRunScore = new LastestRunScore();
        this.add(lastestRunScore);


    }

    public void update() {

    }

    public void drawCurrentScore(Graphics2D graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.setFont(Const.SCORE_TITLE_FONT);
        graphics.drawString("Current Score: " + this.currentScore.getScore(), Const.CURRENT_SCORE_X, Const.CURRENT_SCORE_Y);
    }
    public PlayerScore getCurrentScore() { return this.currentScore; }

    public void addCurrentScore() {
        this.lastestRunScore.addRun(this.currentScore.getScore());
        this.highScore.addScore(this.currentScore);
        this.currentScore = new PlayerScore();
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, Const.WINDOW_HEIGHT);
    }
}
