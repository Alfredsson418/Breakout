package Engine;

import Score.ScoreBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Program extends JFrame {
	GameBoard board;

	ScoreBoard scoreBoard;
	public Program() {

		this.board = new GameBoard();
		this.scoreBoard = new ScoreBoard();

		board.setScoreBoard(scoreBoard);

		this.setLayout(new BorderLayout());

		this.add(board, BorderLayout.CENTER);
		this.add(scoreBoard, BorderLayout.EAST);


		this.setResizable(true);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.board.start();

	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		this.board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
	}

}
