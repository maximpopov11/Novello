package com.yn_1.novello_app.review;

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
        model.postReview(user, rating, review);
    }

    @Override
    public void onReviewSucceeded() {
        view.navigateToBookScreen(model.getBookID());
    }
}
