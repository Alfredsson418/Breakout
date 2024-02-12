package Screens;


import javax.swing.*;
import Const.Const;

public class GameOver extends JComponent {

    public GameOver() {

        JLabel label = new JLabel();
        label.setText("Game Over");
        label.setFont(Const.SCORE_FONT);
        this.add(label);
        setVisible(true);
    }
}
