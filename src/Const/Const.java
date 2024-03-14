package Const;

import java.awt.*;

public class Const {

    // This is basically the settings, anything you change where either changes
    // the appearance of the game or changes the game difficulty

    // random Constants
    public static final int TEN = 10;

    // Window constants
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final int SCOREBOARD_PANEL_WIDTH = 200;


    // Box Constants
    public static final int BOX_WIDTH = 40;
    public static final int BOX_HEIGHT = 20;
    public static final int BOX_PER_ROW = (Const.WINDOW_WIDTH / (Const.BOX_WIDTH)) -  3;

    public static final int BOX_ROWS = 1;
    public static final int EMPTY_ROWS = 2;
    public static final int BOX_WIDTH_OFFSET = (Const.WINDOW_WIDTH - (Const.BOX_PER_ROW * Const.BOX_WIDTH)) / Const.BOX_PER_ROW;
    public static final int BOX_HEIGHT_OFFSET = 5;
    public static final int BOX_COLLECTION_SIZE = Const.BOX_PER_ROW * BOX_ROWS;


    // Player Constants
    public static final int PLAYER_WIDTH = 150;
    public static final int PLAYER_HEIGHT = 20;
    public static final int PLAYER_SPEED = 6;
    public static final int PLAYER_SPEED_BOOST = 14;


    // Ball Constants
    public static final int BALL_WIDTH = 20;
    public static final int BALL_HEIGHT = 20;
    public static final int BALL_START_SPEED = 8;
    public static final int BALL_START_LIVES = 0;
    public static final int BALL_LIVES_X = 500;
    public static final int BALL_LIVES_Y = Const.WINDOW_HEIGHT - 30;
    public static final int BALL_START_X = Const.WINDOW_WIDTH/2 - Const.BALL_WIDTH/2;
    public static final int BALL_START_Y = (Const.WINDOW_HEIGHT / 2);


    // Scoreboard
    public static final Font SCORE_TITLE_FONT = new Font("SCORE_FONT", Font.BOLD, 20);
    public static final Font SCORE_LIST_FONT = new Font("SCORE_LIST_FONT", Font.ITALIC, 15);
    public static final int SCOREBOARD_LATEST_RUNS_LIST_LENGTH = 3;
    public static final int SCOREBOARD_HIGH_SCORE_LIST_LENGTH = 10;
    public static final String HIGH_SCORE_TITLE = "High Score";
    public static final String LATEST_RUN_TITLE = "Latest Run";
    public static final int CURRENT_SCORE_X = 100;
    public static final int CURRENT_SCORE_Y = Const.WINDOW_HEIGHT - 30;


    public static final int INITIALS_LENGTH = 3;




}
