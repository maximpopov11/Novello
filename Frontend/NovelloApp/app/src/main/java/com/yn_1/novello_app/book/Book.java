package com.yn_1.novello_app.book;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageButton;

import com.yn_1.novello_app.message.Message;

import java.io.Serializable;

public class Book implements Serializable, Parcelable {

    //book fields
    int bookID;
    String title;
    String author;
    String genre;
    int publicationYear;
    String isbn;
    double rating;
    double price;
    String description;
    private String readingURL;
    private String imageURL;
    private ImageButton linkedImageButton;

    // User-specific fields, for categories like currently reading, wishlist, etc.
    // Works because each user gets their own instance of book
    // Array because a book can be in multiple categories.
    private String userCategoryID;


    /**
     * Constructor
     * @param title book title
     * @param author book author
     * @param publicationYear book publication year
     * @param isbn book isbn
     * @param rating book rating
     */
    public Book(int bookID, String title, String author, String genre, int publicationYear,
                String isbn, double rating, double price, String description, String readingURL, String imageURL) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.rating = rating;
        this.readingURL = readingURL;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
    }

    /**
     * Constructor for instantiating a copy of the book for the user library
     * @param book The book to be copied
     * @param userCategoryID Categories book should be in for user library
     */
    public Book(Book book, String userCategoryID) {
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

    public Book(Parcel in) {
        this.bookID = in.readInt();
        this.title = in.readString();
        this.author = in.readString();
        this.genre = in.readString();
        this.publicationYear = in.readInt();
        this.isbn = in.readString();
        this.rating = in.readDouble();
        this.readingURL = in.readString();
        this.price = in.readDouble();
        this.description = in.readString();
        this.imageURL = in.readString();
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
     * @return book genre
     */
    public String getGenre() {return genre;}

    /**
     * @return book rating
     */
    public double getRating() {
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
    public String getReadingURL() {
        return readingURL;
    }

    /**
     *
     * @return
     */   
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     */
    public String getDescription() {
        return description;
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
    public String getUserCategoryId() { return userCategoryID; }

    /**
     *
     * @param categoryName
     */
    public void setUserCategoryID(String categoryName) { userCategoryID = categoryName; }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookID);
        dest.writeString(title);
        dest.writeString(author);
        dest.writeString(genre);
        dest.writeInt(publicationYear);
        dest.writeString(isbn);
        dest.writeDouble(rating);
        dest.writeString(readingURL);
        dest.writeDouble(price);
        dest.writeString(description);
        dest.writeString(readingURL);
    }
}
