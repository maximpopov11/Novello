package com.yn_1.novello_app.discovery;

import android.util.Pair;

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

        //constants
        final int MIN_RECOMMENDED_RATING = 3;
        final int AUTHOR_WEIGHT = 3;
        final int GENRE_WEIGHT = 1;

        //author and genre count
        HashMap<String, Integer> authorHashMap = new HashMap<String, Integer>();
        HashMap<String, Integer> genreHashMap = new HashMap<String, Integer>();
        for (Book book : userBooks) {
            String author = book.getAuthor();
            String genre = book.getGenre();
            authorHashMap.put(author, authorHashMap.get(author) + 1);
            genreHashMap.put(genre, genreHashMap.get(genre) + 1);
        }

        //book recommendation rating set
        ArrayList<Pair<Book, Double>> recommendations = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getRating() >= MIN_RECOMMENDED_RATING) {
                Integer numAuthor = authorHashMap.get(book.getAuthor());
                if (numAuthor == null) {
                    numAuthor = 0;
                }
                Integer numGenre = genreHashMap.get(book.getGenre());
                if (numGenre == null) {
                    numGenre = 0;
                }
                double recommendationRating =
                        book.getRating() * Math.max(AUTHOR_WEIGHT * numAuthor, GENRE_WEIGHT * numGenre);
                recommendations.add(new Pair<>(book, recommendationRating));
            }
        }

        //todo: sort recommendations by higher rating first

        //show recommended books
        view.showRecommendedBooks(recommendations);

    }

}
