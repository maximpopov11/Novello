package com.yn_1.novello_app.cart;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageButton;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.volley_requests.ImageRequester;
import com.yn_1.novello_app.volley_requests.JsonArrayRequester;
import com.yn_1.novello_app.volley_requests.JsonObjectRequester;
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
        //todo: 2 represents cart. Set that in an enum.
        cartBookRequester.getRequest("library/" + user.getUserId() + "2", null, command,
                null, null);
    }

    /**
     * Sets user
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Sends cart books to view
     * @param data
     */
    private void booksReceived(JSONArray data) {
        for (int i = 0; i < data.length(); i++) {
            try {
                JSONObject book = data.getJSONObject(i);
                int bookID = book.getInt("bookID");
                String title = book.getString("title");
                String author = book.getString("author");
                String genre = book.getString("genre");
                int publicationYear = book.getInt("publicationYear");
                String isbn = book.getString("isbn");
                double rating = book.getInt("rating");
                double price = book.getDouble("msrp");
                String description = book.getString("description");
                String imageUrl = book.getString("imageUrl");
                String readingUrl = book.getString("readingUrl");
                Book newBook = new Book(bookID, title, author, genre, publicationYear, isbn, rating, price, description, readingUrl, imageUrl);
                newBook.setUserCategoryID("cart");
                cart.add(newBook);
                presenter.sendCart(cart);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Assigns image to book
     * @param book
     * @param imageButton
     */
    public void assignImageToBook(Book book, ImageButton imageButton) {
        ImageRequester req = new ImageRequester();
        req.getRequest(book.getImageURL(), null, new VolleyCommand<Bitmap>() {
            @Override
            public void execute(Bitmap image) {
                Bitmap newImage = Bitmap.createScaledBitmap(image, presenter.view.Image_Width, presenter.view.Image_Height,
                        true);
                imageButton.setImageBitmap(newImage);
            }

            @Override
            public void onError(VolleyError error) { }
        }, null, null);
    }

    /**
     * Removes book from cart
     * @param book
     */
    public void removeBookFromCart(Book book) {
        //todo: delete request to remove book from user
    }

    /**
     * Moves book from cart to waitlsit
     * @param book
     */
    public void moveBookToWaitlist(Book book) {
        //todo: put request on book to move to waitlist
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
