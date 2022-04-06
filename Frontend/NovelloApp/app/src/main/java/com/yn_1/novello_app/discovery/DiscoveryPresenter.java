package com.yn_1.novello_app.discovery;

import com.yn_1.novello_app.book.Book;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Presenter for the discovery screen
 */
public class DiscoveryPresenter {

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
        recommendationAlgorithmRunner();
    }

    /**
     * Receives user's books
     * @param userBooks
     */
    public void sendUserBooks(ArrayList<Book> userBooks) {
        this.userBooks = userBooks;
        recommendationAlgorithmRunner();
    }

    /**
     * Runs recommendation algorithm if it can be run at this time
     */
    private boolean recommendationAlgorithmRunner() {

        if(this.allBooks != null && this.userBooks != null) {
            runRecommendationAlgorithm();
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Recommendation algorithm
     */
    private void runRecommendationAlgorithm() {

        //todo: recommendation algorithm using rating, genre, and author
        //todo: show recommended books

        //go through all user library books
            //count author ++ for respective author
            //count genre ++ for respective genre
        //go through all books
            //if rating >= 3, give recommendation rating:
                //rec rating = max (rating * author weight (3) * count author) or (rating * genre weight (1) * count genre)
        //recommended = top x (< if less than x) recommendation rating books
        //show recommended in view

        HashMap<String, Integer> authorHashMap = new HashMap<String, Integer>();
        HashMap<String, Integer> genreHashMap = new HashMap<String, Integer>();
        for (Book book : userBooks) {
            String author = book.getAuthor();
            String genre = book.getGenre();
            if (authorHashMap.containsKey(author)) {

            }
            else {

            }
        }

    }

}
