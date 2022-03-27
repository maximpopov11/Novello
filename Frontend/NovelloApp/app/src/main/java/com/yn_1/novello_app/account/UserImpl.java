package com.yn_1.novello_app.account;

import com.yn_1.novello_app.library.Book;

import java.util.List;

public class UserImpl implements User {

    String username;

    public UserImpl(String username) {
        this.username = username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public void setAccountType(UserType type) {

    }

    @Override
    public int getUserId() {
        return 0;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public UserType getAccountType() {
        return null;
    }

    @Override
    public List<User> getFriends() {
        return null;
    }

    @Override
    public List<Book> getLibrary() {
        return null;
    }

    @Override
    public String getUserUrlPath() {
        return null;
    }

    @Override
    public void addUserToFriendsList(User user) {

    }
}
