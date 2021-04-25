package domain;

public class Comment
{
    private String SBIN;
    private String comments;
    private int score;

    public String getSBIN() {
        return SBIN;
    }

    public void setSBIN(String SBIN) {
        this.SBIN = SBIN;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "SBIN='" + SBIN + '\'' +
                ", comments='" + comments + '\'' +
                ", score=" + score +
                '}';
    }
}
