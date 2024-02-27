package Score;

import Const.Const;

import javax.swing.*;
import java.awt.*;

public class HighScore extends JPanel {

    private JLabel title;

    private JList list;
    private DefaultListModel<PlayerScore> highScore;

    public HighScore() {
        setLayout(new BorderLayout());


        this.title = new JLabel();
        this.title.setText(Const.HIGH_SCORE_TITLE);
        this.add(this.title, BorderLayout.NORTH);

        this.highScore = new DefaultListModel<>();

        this.list= new JList(this.highScore);
        this.list.setFocusable(false);


        this.add(this.list, BorderLayout.CENTER);
    }

    public void addScore(PlayerScore PlayerScore) {
        this.highScore.add(0, PlayerScore);

        for (int i = 0; i < this.highScore.size() - 1; i++) {
            for (int j = 0; j < this.highScore.size() - i - 1; j++) {
                if (this.highScore.get(j).getScore() < this.highScore.get(j + 1).getScore()) {
                    PlayerScore temp = this.highScore.get(j);
                    this.highScore.set(j, this.highScore.get(j + 1));
                    this.highScore.set(j + 1, temp);
                }
            }
        }


    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, Const.WINDOW_HEIGHT/2);
    }
}
