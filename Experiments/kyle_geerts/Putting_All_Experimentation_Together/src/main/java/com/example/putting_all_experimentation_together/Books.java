package com.example.putting_all_experimentation_together;

public class Books {
    private String title;
    private String author;
    private int isbn;

    public Books(String title, String author, int isbn)
    {
        this.title= title;
        this.author = author;
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }
    @Override
    public String toString() {
        return "Title: " + title + " Author: "
                + author + " isbn: "
                + isbn;
    }
}
