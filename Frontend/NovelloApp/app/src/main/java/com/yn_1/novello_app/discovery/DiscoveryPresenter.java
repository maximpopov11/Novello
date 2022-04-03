package com.yn_1.novello_app.discovery;

/**
 * Presenter for the discoery screen
 */
public class DiscoveryPresenter {

    //todo: get all books
    //todo: recommendation algorithm
    //todo: show recommended books

    DiscoveryView view;
    DiscoveryModel model;

    /**
     * Constructor
     * @param view
     */
    public DiscoveryPresenter(DiscoveryView view) {
        this.view = view;
        this.model = new DiscoveryModel(this);
        model.getAllBooks();
    }

}
