package pl.piotrschodzinski.codeschool.model;

public class MainPageSolution extends Solution {
    private String author;
    private String title;

    public MainPageSolution() {

    }


    public MainPageSolution(String description, int exerciseId, int userId, String author, String title) {
        super(description, exerciseId, userId);
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
