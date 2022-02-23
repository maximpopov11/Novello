package com.yn_1.demo2_volleyproject;

public class Book {

    //book fields
    String title;
    String author;
    int publicationYear;
    String isbn;
    double rating;

    /**
     * Default constructor
     * @param title book title
     * @param author book author
     * @param publicationYear book publication year
     * @param isbn book isbn
     * @param rating book rating
     */
    public Book(String title, String author, int publicationYear, String isbn, double rating) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.rating = rating;
    }

    /**
     * @return book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return string representation of book
     */
    public String toString() {
        return title + " by " + author;
    }

}
