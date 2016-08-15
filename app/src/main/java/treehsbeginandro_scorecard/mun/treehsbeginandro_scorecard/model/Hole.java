package treehsbeginandro_scorecard.mun.treehsbeginandro_scorecard.model;

public class Hole {
    private String holeLabel;
    private int score;

    public String getHoleLabel() {
        return holeLabel;
    }

    public Hole(String holeLabel, int score) {
        this.holeLabel = holeLabel;
        this.score = score;
    }

    public void setHoleLabel(String holeLabel) {
        this.holeLabel = holeLabel;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
