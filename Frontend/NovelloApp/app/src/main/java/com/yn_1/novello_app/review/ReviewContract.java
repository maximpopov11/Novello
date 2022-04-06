package com.yn_1.novello_app.review;

import com.yn_1.novello_app.account.User;

public interface ReviewContract {
    interface Model {
        void postReview(ReviewContract.VolleyListener volleyListener, User user, double rating, String review);
        int getBookID();
    }
    interface View {
        void navigateToBookScreen(int bookID);
    }
    interface Presenter extends VolleyListener {
        void onPostButtonPressed(User user, double rating, String review);
    }
    interface VolleyListener {
        void onReviewSucceeded();
    }
}
