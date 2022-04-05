package com.yn_1.novello_app.discovery;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.volley_requests.JsonArrayRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for the discovery screen
 */
public class DiscoveryModel {

    DiscoveryPresenter presenter;

    /**
     * Constructor
     * @param presenter
     */
    public DiscoveryModel (DiscoveryPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Gets all books to run recommendation algorithm over
     */
    public void getAllBooks() {

        JsonArrayRequester allBooksRequester = new JsonArrayRequester();
        JsonArrayCommand command = new JsonArrayCommand();
        allBooksRequester.getRequest("books", null, command, null, null);

    }

    /**
     * Sends received books to presenter.
     * @param data
     */
    private void sendBooksToPresenter(JSONArray data) {
        ArrayList<Book> allBooks = new ArrayList<>();
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
                Book newBook = new Book(bookID, title, author, publicationYear, isbn, rating, -1, null, imageUrl);
                newBook.setUserCategoryID(categoryPath);
                bookCollection.add(newBook);
                bookCount++;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            presenter.sendAllBooks(allBooks);
        }
        //todo: send books to presenter
    }

    /**
     * Class used to get result of getAllBooks
     */
    private class JsonArrayCommand implements VolleyCommand<JSONArray> {

        @Override
        public void execute(JSONArray data) {
            sendBooksToPresenter(data);
        }

        @Override
        public void onError(VolleyError error) { }

    }

}
