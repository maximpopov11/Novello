package com.yn_1.novello_app.cart;

import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;

import java.util.List;

/**
 * Cart screen model
 */
public class CartModel {

    User user = null;

    /**
     * Constructor
     */
    public CartModel() {

    }

    /**
     * @return books in cart
     */
    public List<Book> getCartBooks() {
        //todo: get user cart books
        return null;
    }

    /**
     * Sets user
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
