package com.yn_1.novello_app.library;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;

import com.yn_1.novello_app.account.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryPresenter implements LibraryContract.Presenter {

    private LibraryContract.Model model;
    private LibraryContract.View view;

    private List<ImageButton> bookButtons;

    public LibraryPresenter(LibraryContract.Model model, LibraryContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onViewCreated(User user, Context context) {
        model.fetchAllBooks(user);

        bookButtons = new ArrayList<ImageButton>();
        for (Book book : model.getUserBookCollection()) {
            bookButtons.add(createBookButton(book, context));
        }

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
    public ImageButton createBookButton(Book book, Context context) {
        ImageButton button = new ImageButton(context);

        LayoutParams params = new LayoutParams(175,
                HorizontalScrollView.LayoutParams.MATCH_PARENT);
        params.setMargins(5, 0, 5, 0);
        button.setLayoutParams(params);
        button.setBackgroundColor(Color.YELLOW);

        model.assignImageToBook(book.getImageURL(), button);

        button.setOnClickListener(v -> {
            onBookTapped(book);
        });
        button.setOnLongClickListener(null); //TODO: Hold to show dialog to remove, rate, etc.
        return button;
    }

    @Override
    public List<ImageButton> getBookButtons() {
        return bookButtons;
    }
}
