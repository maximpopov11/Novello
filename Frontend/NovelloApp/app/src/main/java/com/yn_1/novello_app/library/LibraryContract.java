package com.yn_1.novello_app.library;

import android.content.Context;
import android.widget.ImageButton;

import com.yn_1.novello_app.account.User;

import java.util.List;

public interface LibraryContract {
    interface Model {
        void fetchAllBooks(User user);
        ImageButton createImageFromBook(Book book, Context context);
        List<Book> getBookCollection(List<Book> books);
        List<Book> addBookToCollection(Book book);
        List<Book> removeBookFromCollection(Book book);
    }

    interface View {
        void displayAllBooks(List<Book> books);
        void displayBook(Book book);
    }

    interface Presenter {
        void onViewCreated(User user);
        void onBookTapped(User user, Book book);
        void onBookHeld(User user, Book book);
    }
}
