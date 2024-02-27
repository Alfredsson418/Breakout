package Score;

import Const.Const;

import javax.swing.*;
import java.awt.*;

public class LastestRunScore extends JPanel {

    private JLabel title;

    private JList list;
    private DefaultListModel<String> latest;


    public LastestRunScore() {
        setLayout(new BorderLayout());


        this.title = new JLabel();
        this.title.setText(Const.LATEST_RUN_TITLE);
        this.add(this.title, BorderLayout.NORTH);

        this.latest = new DefaultListModel<>();

        this.list= new JList(this.latest);
        this.list.setFocusable(false);


        this.add(this.list, BorderLayout.CENTER);

    }

    public void addRun(int score) {
        this.latest.add(0, "Score: " + score);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, Const.WINDOW_HEIGHT/2);
    }

}
