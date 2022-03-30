package com.yn_1.novello_app.cart;

import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;

import java.util.List;

/**
 * Cart screen presenter
 */
public class CartPresenter {

    CartModel model;
    User user;

    public CartPresenter() {
        model = new CartModel();
    }

    public List<Book> getCartBooks() {
        return model.getCartBooks();
    }

    public void setUser(User user) {
        this.user = user;
        model.setUser(user);
    }

}
