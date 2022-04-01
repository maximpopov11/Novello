package com.yn_1.novello_app.book;

public class BookModel implements BookContract.Model {
    @Override
    public Book getBook() {
        return null;
    }

    @Override
    public void fetchReviews() {

    }

    @Override
    public Object[] getReviews() {
        return new Object[0];
    }
}
