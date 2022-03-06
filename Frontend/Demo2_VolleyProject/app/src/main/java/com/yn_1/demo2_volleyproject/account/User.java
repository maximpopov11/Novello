package com.yn_1.demo2_volleyproject.account;

import com.yn_1.demo2_volleyproject.library.Book;

import java.util.List;

/**
 * User interface <br>
 * The creation of a user account should be done in user implementation constructor.
 */
public interface User {

    void setUsername(String username);
    void setPassword(String password);
    void setAccountType(UserType type);


    int getUserId();
    String getUsername();
    String getPassword();
    UserType getAccountType();
    List<User> getFriends();
    List<Book> getLibrary();
    String getUserUrlPath();


    void addUserToFriendsList(User user);
}
