package com.yn_1.novello_app.account;

import com.yn_1.novello_app.cart.CartModel;
import com.yn_1.novello_app.cart.CartView;

/**
 * Profile screen presenter
 */
public class ProfilePresenter {

    ProfileView view;
    ProfileModel model;

    User user;

    /**
     * Constructor
     * Creates model
     */
    public ProfilePresenter(ProfileView view) {
        this.view = view;
        model = new ProfileModel(this);
    }

    /**
     * Sets user for Presenter and Model
     * @param user current user
     */
    public void setUser(User user) {
        this.user = user;
        model.setUser(user);
    }

}
