package com.yn_1.novello_app.cart;

import com.yn_1.novello_app.book.Book;

import java.util.List;

/**
 * Cart screen presenter
 */
public class CartPresenter {

    CartModel model;

    public CartPresenter() {
        model = new CartModel();
    }

    public List<Book> getCartBooks() {
        return model.getCartBooks();
    }

}
