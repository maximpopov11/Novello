package com.yn_1.novello_app.library;

import android.widget.ImageButton;

import java.util.List;

public class Book {

    //book fields
    String title;
    String author;
    int publicationYear;
    String isbn;
    int rating;
    int bookID;
    private String imageURL;
    private ImageButton linkedImageButton;

    // User-specific fields, for categories like currently reading, wishlist, etc.
    // Works because each user gets their own instance of book
    // Array because a book can be in multiple categories.
    private List<String> userCategoryID;


    /**
     * Constructor
     * @param title book title
     * @param author book author
     * @param publicationYear book publication year
     * @param isbn book isbn
     * @param rating book rating
     */
    public Book(int bookID, String title, String author, int publicationYear, String isbn, int rating, String imageURL) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.rating = rating;
        this.imageURL = imageURL;
    }

    /**
     * Constructor for instantiating a copy of the book for the user library
     * @param book The book to be copied
     * @param userCategoryID Categories book should be in for user library
     */
    public Book(Book book, List<String> userCategoryID) {
        bookID = book.bookID;
        title = book.title;
        author = book.author;
        publicationYear = book.publicationYear;
        isbn = book.isbn;
        rating = book.rating;
        imageURL = book.imageURL;

        this.userCategoryID = userCategoryID;
    }

    /**
     * Constructor
     * @param title book title
     */
    public Book(String title) {
        this.title = title;
        this.author = "unknown author";
        this.publicationYear = -1;
        this.isbn = "unknown isbn";
        this.rating = -1;
    }

    /**
     * @return book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return book author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return book rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @return book isbn
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * @return string representation of book
     */
    public String toString() {
        return title + " by " + author;
    }

    /**
     * @return book id
     */
    public int getBookID() {
        return bookID;
    }

    /**
     *
     * @return
     */
    public String getImageURL() { return imageURL; }

    /**
     *
     * @return
     */
    public ImageButton getImageButton() { return linkedImageButton; }

    /**
     *
     * @param button
     */
    public void setImageButton(ImageButton button) { linkedImageButton = button; }

    /**
     *
     * @return
     */
    public List<String> getUserCategoryId() { return userCategoryID; }

    /**
     *
     * @param categoryName
     */
    public void addUserCategoryID(String categoryName) { userCategoryID.add(categoryName); }
}
