package com.yn_1.novello_app.cart;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.volley_requests.JsonArrayRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Cart screen model
 */
public class CartModel {

    CartPresenter presenter;

    User user = null;
    ArrayList<Book> cart = new ArrayList<>();

    /**
     * Constructor
     */
    public CartModel(CartPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @return books in cart
     */
    public void getCartBooks() {
        JsonArrayRequester cartBookRequester = new JsonArrayRequester();
        JsonArrayCommand command = new JsonArrayCommand();
        cartBookRequester.getRequest(user.getUsername() + "/library/cart", null, command,
                null, null);
    }

    /**
     * Sets user
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    private void booksReceived(JSONArray data) {
        for (int i = 0; i < data.length(); i++) {
            try {
                JSONObject book = data.getJSONObject(i);
                int bookID = book.getInt("bookID");
                String title = book.getString("title");
                String author = book.getString("author");
                int publicationYear = book.getInt("publicationYear");
                String isbn = book.getString("isbn");
                int rating = book.getInt("rating");
                String imageUrl = book.getString("imageUrl");
                Book newBook = new Book(bookID, title, author, publicationYear, isbn, rating, imageUrl);
                newBook.setUserCategoryID("cart");
                cart.add(newBook);
                presenter.sendCart(cart);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Class used to get result of array request
     */
    private class JsonArrayCommand implements VolleyCommand<JSONArray> {

        @Override
        public void execute(JSONArray data) {
            booksReceived(data);
        }

        @Override
        public void onError(VolleyError error) {

        }

    }

}
