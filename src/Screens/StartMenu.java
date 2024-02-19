package Screens;

import Const.Const;
import Engine.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JPanel implements ActionListener {

    JFrame frame;


    JButton startButton;
    JButton exitButton;
    public StartMenu(JFrame frame) {
        this.create();
        this.frame = frame;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
    }

    public void create() {
        JLabel label = new JLabel();
        label.setText("Start Menu!");
        label.setFont(Const.SCORE_FONT);

        startButton = new JButton("Start Game");
        startButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);


        this.add(label);
        this.add(startButton);
        this.add(exitButton);


        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(exitButton)) {
            System.exit(0);
        } else if (actionEvent.getSource().equals(startButton)) {


            this.setVisible(false);



            GameBoard game = new GameBoard();


            frame.add(game);
            frame.pack();
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            game.setVisible(true);

            game.start();

            // board.start();


        }
    }
}
