package com.yn_1.novello_app.book;

import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.volley_requests.ImageRequester;
import com.yn_1.novello_app.volley_requests.JsonArrayRequester;
import com.yn_1.novello_app.volley_requests.JsonObjectRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookModel implements BookContract.Model {

    private int bookID;
    private Book currentBook;
    private Bitmap currentCover;
    private Map<Integer, String[]> reviews;

    public BookModel(int bookID) {
        this.bookID = bookID;
    }

    @Override
    public void fetchBook(BookContract.View view) {
        JsonObjectRequester req = new JsonObjectRequester();
        req.getRequest("books/" + bookID, null, new VolleyCommand<JSONObject>() {
            @Override
            public void execute(JSONObject data) {
                try {
                    String titleText = data.getString("title");
                    String authorText = data.getString("author");
                    int publicationYearText = data.getInt("publicationYear");
                    String isbnText = data.getString("isbn");
                    double ratingText = data.getDouble("rating");
                    double priceText = data.getDouble("price");
                    Log.d("price", "Book price: " + priceText);
                    String descriptionText = data.getString("description");
                    String imageURL = data.getString("imageUrl");
                    currentBook = new Book(bookID, titleText, authorText, publicationYearText, isbnText,
                            ratingText, priceText, descriptionText, imageURL);
                    fetchImage(imageURL, view);
                }
                catch (JSONException e) {

                }
            }

            @Override
            public void onError(VolleyError error) {

            }
        }, null, null);
    }

    @Override
    public void fetchImage(String imageURL, BookContract.View view) {
        ImageRequester req = new ImageRequester();
        req.getRequest(imageURL, null, new VolleyCommand<Bitmap>() {
            @Override
            public void execute(Bitmap image) {
                currentCover = Bitmap.createScaledBitmap(image, BOOK_SIZE[0], BOOK_SIZE[1], true);
                fetchReviews(view);
            }

            @Override
            public void onError(VolleyError error) {
                Log.d("Image Load Error", imageURL);
            }
        }, null, null);
    }

    @Override
    public Book getBook() {
        return currentBook;
    }

    @Override
    public Bitmap getBookCover() {
        return currentCover;
    }

    @Override
    public void fetchReviews(BookContract.View view) {
        JsonArrayRequester req = new JsonArrayRequester();
        req.getRequest("books/" + bookID + "/reviews", null, new VolleyCommand<JSONArray>() {
            @Override
            public void execute(JSONArray data) {
                reviews = new HashMap<>();
                for (int i = 0; i < data.length(); i++) {
                    try {
                        JSONObject object = data.getJSONObject(i);
                        String userID = object.getString("userId");
                        String rating = object.getString("rating");
                        String review = object.getString("review");
                        reviews.put(i, new String[]{userID, rating, review});
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                view.startView();
            }

            @Override
            public void onError(VolleyError error) {

            }
        }, null, null);
    }

    @Override
    public Map<Integer, String[]> getReviews() {
        return reviews;
    }
}