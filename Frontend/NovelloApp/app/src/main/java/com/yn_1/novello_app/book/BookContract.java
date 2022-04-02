package com.yn_1.novello_app.book;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Contract for Book's MVP Design Pattern.
 */
public interface BookContract {
    /**
     * Model <br>
     * For storing data and communicating with database.
     */
    interface Model {
        int[] BOOK_SIZE = {175*2, 280*2};
        void fetchBook(BookContract.View view);
        void fetchImage(String imageUrl, BookContract.View view);
        Book getBook();
        Bitmap getBookCover();
        void fetchReviews();
        Object[] getReviews();
    }

    /**
     * View <br>
     * For displaying data via the UI. Is the fragment of the screen.
     */
    interface View {
        void startView();
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

        void onDisplayBookCover(ImageView coverView);
    }
}
