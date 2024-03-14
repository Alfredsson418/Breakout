package Score;

import Const.Const;

import javax.swing.*;
import java.awt.*;

public class LatestRunScore extends JPanel {

    private JLabel title;

    private JList list;
    private DefaultListModel<String> latest;


    public LatestRunScore() {
        setLayout(new BorderLayout());


        this.title = new JLabel();
        this.title.setText(Const.LATEST_RUN_TITLE);
        this.add(this.title, BorderLayout.NORTH);

        this.latest = new DefaultListModel<>();

        this.list= new JList(this.latest);
        this.list.setFont(Const.SCORE_LIST_FONT);
        this.list.setFocusable(false);


        this.add(this.list, BorderLayout.CENTER);

    }

    public void update() {
        if (this.latest.size() > Const.SCOREBOARD_LATEST_RUNS_LIST_LENGTH){
            this.latest.remove(this.latest.size() - 1);
        }
    }

    public void addRun(int score) {
        this.latest.add(0, String.valueOf(score));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Const.SCOREBOARD_PANEL_WIDTH, Const.WINDOW_HEIGHT/2);
    }

}
