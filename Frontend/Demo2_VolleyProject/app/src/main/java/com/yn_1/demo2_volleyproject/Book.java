package com.yn_1.demo2_volleyproject;

public class Book {

    String title;
    String author;
    int publicationYear;
    int isbn;
    double rating;

    public Book(String title, String author, int publicationYear, int isbn, double rating) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.rating = rating;
    }

    public String toString() {
        return title + " by " + author;
    }

}
