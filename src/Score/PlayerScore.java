package Score;

public class PlayerScore {

    private int score;

    private String initials;

    public PlayerScore() {}

    public void setScore(int score) { this.score = score; }

    public int getScore() { return this.score; }

    public void setInitials(String initials) { this.initials = initials; }

    public String getInitials() { return this.initials; }

    public String getText() {
        return this.initials + " : " + this.score;
    }

    @Override
    public String toString() {
        return this.initials + "  :  " + this.score;
    }
}
