package Engine;

import Score.ScoreBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Program extends JFrame {
	GameBoard board;

	ScoreBoard scoreBoard;
	public Program() {

		board = new GameBoard();
		scoreBoard = new ScoreBoard();
		this.setLayout(new BorderLayout());
		add(board, BorderLayout.CENTER);
		add(scoreBoard, BorderLayout.EAST);
		setResizable(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board.start();

	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
	}

}
