package com.yn_1.novello_app.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.TableRow;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.volley_requests.ImageRequester;
import com.yn_1.novello_app.volley_requests.JsonArrayRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LibraryModel implements LibraryContract.Model {

    private List<Book> bookCollection;

    @Override
    public void fetchAllBooks(User user) {
        bookCollection = new ArrayList<>();

        JsonArrayRequester req = new JsonArrayRequester();
        req.getRequest(user.getUserId()+"library", null, new VolleyCommand<JSONArray>()
        {
            @Override
            public void execute(JSONArray data) {
                for (int i = 0; i < data.length(); i++)
                {
                    try {
                        JSONObject book = data.getJSONObject(i);
                        int bookID = book.getInt("bookID");
                        String title = book.getString("title");
                        String author = book.getString("author");
                        int publicationYear = book.getInt("publicationYear");
                        String isbn  = book.getString("isbn");
                        int rating = book.getInt("rating");
                        String imageUrl = book.getString("imageUrl");
                        Book newBook = new Book(bookID, title, author, publicationYear, isbn, rating, imageUrl);
                        bookCollection.add(newBook);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(VolleyError error) {

            }
        }, null, null);
    }

    @Override
    public void assignImageToBook(String imageURL, ImageButton button) {
        ImageRequester req = new ImageRequester();
        req.getRequest(imageURL, null, new VolleyCommand<Bitmap>() {
            @Override
            public void execute(Bitmap image) {
                button.setImageBitmap(image);
            }

            @Override
            public void onError(VolleyError error) { }
        }, null, null);
    }

    @Override
    public List<Book> getUserBookCollection() {
        return bookCollection;
    }

    // TODO: Press add button to add book to collection
    @Override
    public List<Book> addBookToCollection(Book book) {
        return null;
    }

    // TODO: Hold book to remove book from collection
    @Override
    public List<Book> removeBookFromCollection(Book book) {
        return null;
    }
}
