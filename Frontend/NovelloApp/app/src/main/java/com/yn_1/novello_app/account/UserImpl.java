package com.yn_1.novello_app.account;

import com.yn_1.novello_app.book.Book;

import java.util.List;

public class UserImpl implements User {

    String username;
    UserType userType;

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
    public void setUserType(UserType type) {
        this.userType = type;
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
    public UserType getUserType() {
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
