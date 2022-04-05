package com.yn_1.novello_app.discovery;

import com.yn_1.novello_app.book.Book;

import java.util.ArrayList;

/**
 * Presenter for the discovery screen
 */
public class DiscoveryPresenter {

    //todo: get user books: url = "library/personID"
    //todo: recommendation algorithm using rating, genre, and author
    //todo: show recommended books

    DiscoveryView view;
    DiscoveryModel model;

    ArrayList<Book> allBooks;
    ArrayList<Book> userBooks;

    /**
     * Constructor
     * @param view
     */
    public DiscoveryPresenter(DiscoveryView view) {
        this.view = view;
        this.model = new DiscoveryModel(this);
        model.getAllBooks();
        model.getUserBooks();
    }

    /**
     * Receives all books
     * @param allBooks
     */
    public void sendAllBooks(ArrayList<Book> allBooks) {
        this.allBooks = allBooks;
    }

    /**
     * Receives user's books
     * @param userBooks
     */
    public void sendUserBooks(ArrayList<Book> userBooks) {
        this.userBooks = userBooks;
    }

}
