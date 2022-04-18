package com.yn_1.novello_app.account;

import com.yn_1.novello_app.cart.CartPresenter;

import java.util.ArrayList;

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

    /**
     * Receives the friends list from the database
     */
    public void getFriendsList() {
        //todo: backend request to get friends
    }

    /**
     * Sends friends list to presenter
     * @param friendsList is the user's friend list
     */
    private void setFriendsList(ArrayList<User> friendsList) {
        presenter.setFriendsList(friendsList);
    }

}
