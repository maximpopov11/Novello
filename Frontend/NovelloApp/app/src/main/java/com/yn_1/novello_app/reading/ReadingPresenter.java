package com.yn_1.novello_app.reading;

import com.yn_1.novello_app.account.User;

public class ReadingPresenter implements ReadingContract.Presenter {

    // Model and View accessible from Presenter
    ReadingContract.Model model;
    ReadingContract.View view;

    public ReadingPresenter(ReadingContract.Model model, ReadingContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onPageLoad(User user) {
        model.fetchProgress(user, model.getBookId(), view);
    }

    @Override
    public void onEscape(User user) {
        model.saveProgress(user, model.getBookId(), view.getProgress());
    }
}
