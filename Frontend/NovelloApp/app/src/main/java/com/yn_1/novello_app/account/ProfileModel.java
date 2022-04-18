package com.yn_1.novello_app.account;

import com.yn_1.novello_app.cart.CartPresenter;

/**
 * Profile screen model.
 */
public class ProfileModel {

    ProfilePresenter presenter;

    User user;

    /**
     * Constructor
     * Creates a presenter
     */
    public ProfileModel(ProfilePresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Sets the user
     * @param user current user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
