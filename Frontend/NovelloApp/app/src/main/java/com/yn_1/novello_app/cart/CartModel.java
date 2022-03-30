package com.yn_1.novello_app.cart;

import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;

import java.util.List;

/**
 * Cart screen model
 */
public class CartModel {

    User user;

    public CartModel() {

    }

    public List<Book> getCartBooks() {
        //todo: find user
        //todo: get user cart books
        return null;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
