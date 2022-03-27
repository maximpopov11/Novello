package com.yn_1.novello_app.library;

import android.content.Context;
import android.widget.ImageButton;

import com.yn_1.novello_app.account.User;

import java.util.List;

/**
 * Controller for Library's MVP Design Pattern.
 */
public interface LibraryContract {
    /**
     * Model <br>
     * For storing data and communicating with database.
     */
    interface Model {
        /**
         * Fetches all books in the user library from the database
         * @param user
         */
        void fetchAllBooks(User user, LibraryContract.View view, LibraryContract.Presenter presenter);

        /**
         * Fetches the cover image of the book from the database, and assigns it to the book
         * @param imageURL
         * @param button
         */
        void assignImageToBook(String imageURL, ImageButton button, LibraryContract.View presenter);

        /**
         * Returns the user book collection
         * @return
         */
        List<Book> getUserBookCollection();

        /**
         * Adds a book to the user library in the database, and refreshes the content
         * @param book
         * @return
         */
        List<Book> addBookToCollection(Book book);

        /**
         * Removes a book from the user library in the database, and refreshes the content
         * @param book
         * @return
         */
        List<Book> removeBookFromCollection(Book book);
    }

    /**
     * View <br>
     * For displaying data via the UI. Is the fragment of the screen.
     */
    interface View {
        /**
         * Displays all the books
         * @param books
         */
        void displayAllBooks(List<Book> books);

        /**
         * Transitions to the book screen fragment for displaying a specific book.
         * @param book
         */
        void displayBook(Book book);

        void startPresenter();
    }

    /**
     * Presenter <br>
     * For handling UI logic.
     */
    interface Presenter {

        void beforeViewCreated(User user);

        /**
         * Handles initialization logic when the library fragment is displayed.
         * @param user
         * @param context
         */
        void onViewCreated(User user, Context context);

        /**
         * Handles logic when a book is tapped
         * @param book
         */
        void onBookTapped(Book book);

        /**
         * Handles logic when a book is held.
         * @param book
         */
        void onBookHeld(Book book);

        /**
         * Creates an image button for the book.
         * @param context
         * @return
         */
        void createBookButtons(Context context);

        /**
         * Obtains all image buttons of books. Note: May be redundant.
         * @return
         */
        List<ImageButton> getBookButtons();
    }
}
