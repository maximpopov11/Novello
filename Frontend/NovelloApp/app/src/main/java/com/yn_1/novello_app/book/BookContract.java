package com.yn_1.novello_app.book;

/**
 * Contract for Book's MVP Design Pattern.
 */
public interface BookContract {
    /**
     * Model <br>
     * For storing data and communicating with database.
     */
    interface Model {
        Book fetchBook();
        Book getBook();
        void fetchReviews();
        Object[] getReviews();
    }

    /**
     * View <br>
     * For displaying data via the UI. Is the fragment of the screen.
     */
    interface View {
        void startPresenter();
        void displayComponents(Book book);
    }

    /**
     * Presenter <br>
     * For handling UI logic.
     */
    interface Presenter {
        /**
         * Handles initialization logic before the library fragment is displayed.
         */
        void beforeViewCreated();

        /**
         * Handles initialization logic when the library fragment is displayed.
         */
        void onViewCreated();
    }
}
