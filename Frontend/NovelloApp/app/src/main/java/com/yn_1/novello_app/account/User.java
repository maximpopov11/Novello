package com.yn_1.novello_app.account;

import com.yn_1.novello_app.book.Book;

import java.util.List;

/**
 * User interface <br>
 * The creation of a user account should be done in user implementation constructor.
 * @author Roba Abbajabal
 */
public interface User {

    /**
     * Sets the username
     * @param username
     */
    void setUsername(String username);

    /**
     * Sets the password
     * @param password
     */
    void setPassword(String password);

    /**
     * Sets the user type
     * @param type
     */
    void setUserType(UserType type);

    /**
     * @return the user ID
     */
    int getUserId();

    /**
     * @return the username
     */
    String getUsername();

    /**
     * @return the password
     */
    String getPassword();

    /**
     * @return the user type
     */
    UserType getUserType();

    /**
     * @return a list of friends
     */
    List<User> getFriends();

    /**
     * @return a list of books in the library
     */
    List<Book> getLibrary();

    /**
     * @return the user URL path
     */
    String getUserUrlPath();

    /**
     * Adds the given user to the friends list
     * @param user
     */
    void addUserToFriendsList(User user);
}
