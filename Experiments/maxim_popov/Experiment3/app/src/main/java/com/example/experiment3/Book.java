package com.example.experiment3;

public class Book {

    public String title;
    public String author;
    public String series;
    public BookType type;
    public double rating;

    public Book(String title, String author, BookType type) {

        this.title = title;
        this.author = author;
        this.series = null;
        this.type = type;
        this.rating = 0;

    }

    public Book(String title, String author, String series, BookType type, double rating) {

        this.title = title;
        this.author = author;
        this.series = series;
        this.type = type;
        this.rating = rating;

    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}
