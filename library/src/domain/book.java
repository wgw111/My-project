package domain;

import java.util.List;

public class book
{
    private String SBIN;
    private String name;
    private String author;
    private int day;
    private List<String> comments;
    private String isBrought;
    private String position;

    public String getSBIN() {
        return SBIN;
    }

    public void setSBIN(String SBIN) {
        this.SBIN = SBIN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getIsBrought() {
        return isBrought;
    }

    public void setIsBrought(String isBrought) {
        this.isBrought = isBrought;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "book{" +
                "SBIN='" + SBIN + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", day=" + day +
                ", comments=" + comments +
                ", isBrought='" + isBrought + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
