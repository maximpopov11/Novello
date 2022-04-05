package com.yn_1.novello_app.library;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;

public class LibraryPresenter implements LibraryContract.Presenter {

    // Model and View accessible from Presenter
    private LibraryContract.Model model;
    private LibraryContract.View view;

    private ImageButton currentMenuButton;

    public LibraryPresenter(LibraryContract.Model model, LibraryContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void beforeViewCreated(User user) {
        Log.d("Presenter", "beforeViewCreated() called");
        model.fetchAllBooks(user, view, this);
    }

    @Override
    public void onViewCreated(User user, Context context) {
        view.displayAllBooks(model.getUserBookCollection());
    }

    @Override
    public void onBookTapped(Book book) {
        view.displayBook(book);
    }

    // TODO: On book held, allow user to remove book or rate book in user collection
    @Override
    public void onBookHeld(Book book) { }

    @Override
    public void createBookButtons(Context context) {
        Log.d("Library", "Book collection size " + model.getUserBookCollection().size());
        for (Book book : model.getUserBookCollection()) {
            ImageButton button = new ImageButton(context);

            LayoutParams params = new LayoutParams(model.BOOK_SIZE[0],
                    model.BOOK_SIZE[1]);
            params.setMargins(15, 0, 15, 0);
            button.setLayoutParams(params);
            button.setBackgroundColor(Color.YELLOW);

            model.assignImageToBook(book, book.getImageURL(), button, view);

            // Click listener
            button.setOnClickListener(v -> {
                onBookTapped(book);
            });
            // Long click listener
            ((Fragment)view).registerForContextMenu(button);

            model.addBookButton(book, button);
            book.setImageButton(button);
        }
    }

    @Override
    public void createBookMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Book Options");
        menu.add(0, v.getId(), 0, "Go To Book");
        menu.add(0, v.getId(), 1, "Read Book");
        //TODO: Add more menu options
        currentMenuButton = (ImageButton)v;
    }

    @Override
    public void onBookMenuItemSelected(MenuItem item) {
        if (item.getTitle() == "Go To Book") {
            view.displayBook(model.getBookButton(currentMenuButton));
        }
        if (item.getTitle() == "Read Book") {
            Book book = model.getBookButton(currentMenuButton);
            if (book.getUserCategoryId() == "currentlyReading") {
                view.readBook(book);
            }
            else
            {
                Toast toast = Toast.makeText(currentMenuButton.getContext(),
                        "Error: App not owned or not in currently reading category.",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
