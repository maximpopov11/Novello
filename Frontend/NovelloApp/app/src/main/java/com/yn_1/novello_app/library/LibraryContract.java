package com.yn_1.novello_app.library;

import android.content.Context;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;

import java.util.List;
import java.util.Map;

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
         * Constant values
         * COLLECTION_COUNT: Number of collection {e.g.: Reading, Wishlist, etc.}
         * BOOK_SIZE: The dimensions of a book
         */
        int COLLECTION_COUNT = 3;
        int[] BOOK_SIZE = {175*3, 280*3};

        /**
         * Fetches all books in the user library from the database.
         * @param user
         */
        void fetchAllBooks(User user, LibraryContract.View view, LibraryContract.Presenter presenter);

        /**
         * Fetches the cover image of the book from the database, and assigns it to the book.
         * @param imageURL
         * @param button
         */
        void assignImageToBook(Book book, String imageURL, ImageButton button, LibraryContract.View presenter);

        /**
         * Returns the user book collection.
         * @return
         */
        List<Book> getUserBookCollection();

        /**
         * Adds a book to the user library in the database, and refreshes the content.
         * @param book
         * @return
         */
        List<Book> addBookToCollection(Book book);

        /**
         * Removes a book from the user library in the database, and refreshes the content.
         * @param book
         * @return
         */
        List<Book> removeBookFromCollection(Book book);

        /**
         * Obtains all image buttons of books. Note: May be redundant.
         * @return
         */
        Map<ImageButton, Book> getBookButtons();

        /**
         * Add image buttons to collection. Note: May be redundant.
         * @param button
         */
        void addBookButton(Book book, ImageButton button);

        /**
         * Searches for book button in collection.
         * @param button
         */
        Book getBookButton(ImageButton button);
    }

    /**
     * View <br>
     * For displaying data via the UI. Is the fragment of the screen.
     */
    interface View {
        /**
         * Starts the initial presenter code.
         */
        void startPresenter();

        /**
         * Displays all the books.
         * @param books
         */
        void displayAllBooks(List<Book> books);

        /**
         * Transitions to the book screen fragment for displaying a specific book.
         * @param book
         */
        void displayBook(Book book);
    }

    /**
     * Presenter <br>
     * For handling UI logic.
     */
    interface Presenter {

        /**
         * Handles initialization logic before the library fragment is displayed.
         * @param user
         */
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
         */
        void createBookButtons(Context context);

        /**
         * Creates book menu
         * @param menu
         * @param v
         * @param menuInfo
         */
        void createBookMenu(ContextMenu menu, android.view.View v, ContextMenu.ContextMenuInfo menuInfo);

        /**
         * Handles logic for book menu item selection
         */
        void onBookMenuItemSelected(MenuItem item);
    }
}
