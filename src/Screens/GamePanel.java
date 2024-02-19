package Screens;

import Const.Const;
import Engine.GameBoard;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    GameBoard board;
    public GamePanel() {

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
    }

}
