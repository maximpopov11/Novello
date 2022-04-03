package com.yn_1.novello_app.discovery;

/**
 * Presenter for the discoery screen
 */
public class DiscoveryPresenter {

    DiscoveryView view;
    DiscoveryModel model;

    /**
     * Constructor
     * @param view
     */
    public DiscoveryPresenter(DiscoveryView view) {
        this.view = view;
        this.model = new DiscoveryModel(this);
    }

}
