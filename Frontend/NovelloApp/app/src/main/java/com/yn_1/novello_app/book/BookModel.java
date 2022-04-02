package com.yn_1.novello_app.book;

public class BookModel implements BookContract.Model {

    private Book currentBook;

    @Override
    public Book fetchBook() {
        return null;
    }

    @Override
    public Book getBook() {
        return currentBook;
    }

    @Override
    public void fetchReviews() {

    }

    @Override
    public Object[] getReviews() {
        return new Object[0];
    }
}
