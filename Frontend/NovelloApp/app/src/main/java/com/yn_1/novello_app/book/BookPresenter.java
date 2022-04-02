package com.yn_1.novello_app.book;

public class BookPresenter implements BookContract.Presenter {

    private BookContract.Model model;
    private BookContract.View view;

    public BookPresenter(BookContract.Model model, BookContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void beforeViewCreated() {
        model.fetchBook();
    }

    @Override
    public void onViewCreated() {
        // Display stuff with view call, getting book from model class
        view.displayComponents(model.getBook());
    }
}
