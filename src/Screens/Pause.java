package Screens;

import javax.swing.*;
import Const.Const;

import java.awt.*;

public class Pause extends JPanel {

    public Pause() {
        JLabel pausedLabel = new JLabel("PAUSED");
        pausedLabel.setForeground(Color.ORANGE);
        JPanel pausedPanel = new JPanel();
        pausedPanel.setOpaque(false);
        pausedPanel.add(pausedLabel);

        setBackground(Color.WHITE);
        setLayout(new GridLayout(0, 1, 10, 10));
        add(pausedPanel);
    }

}
