package com.yn_1.novello_app.library;

import android.widget.ImageButton;

import com.yn_1.novello_app.account.User;

public interface LibraryContract {
    interface Model {
        void fetchAllBooks(User user);
        ImageButton createImageFromBook(Book book);
    }

    interface View {
        void displayAllBooks(Book[] books);
        void displayBook(Book book);
    }

    interface Presenter {
        void onViewCreated(User user);
        void onBookTapped(User user, Book book);
    }
}
