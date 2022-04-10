package com.yn_1.novello_app.review;

import android.util.Log;

import com.yn_1.novello_app.account.User;

public class ReviewPresenter implements ReviewContract.Presenter {

    ReviewContract.View view;
    ReviewContract.Model model;

    public ReviewPresenter (ReviewContract.View view, ReviewContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onPostButtonPressed(User user, double rating, String review) {
        model.postReview(this, user, rating, review);
    }

    @Override
    public void onReviewSucceeded() {
        Log.d("Review", "Listener succeeded");
        view.navigateToBookScreen(model.getBookID());
    }
}