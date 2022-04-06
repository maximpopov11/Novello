package com.yn_1.novello_app.review;

import com.yn_1.novello_app.account.User;

public class ReviewModel implements ReviewContract.Model {

    private ReviewContract.VolleyListener volleyListener;
    private int bookID;

    public ReviewModel(ReviewContract.VolleyListener volleyListener, int bookID) {
        this.volleyListener = volleyListener;
        this.bookID = bookID;
    }

    @Override
    public void postReview(User user, double rating, String review) {

    }

    @Override
    public int getBookID() {
        return bookID;
    }
}
