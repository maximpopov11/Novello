package com.example.experiment3;

public class Book {

    private String title;
    private String author;
    private String series;
    private BookType type;

    public Book(String title, String author, BookType type) {

        this.title = title;
        this.author = author;
        this.series = null;
        this.type = type;

    }

    public Book(String title, String author, String series, BookType type) {

        this.title = title;
        this.author = author;
        this.series = series;
        this.type = type;

    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}
