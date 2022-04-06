package com.yn_1.novello_app.review;

import android.util.Log;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.volley_requests.JsonObjectRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONException;
import org.json.JSONObject;

public class ReviewModel implements ReviewContract.Model {

    private int bookID;

    public ReviewModel(int bookID) {
        this.bookID = bookID;
    }

    @Override
    public void postReview(ReviewContract.VolleyListener volleyListener, User user, double rating, String review) {
        JSONObject post = new JSONObject();
        try {
            post.put("userId", user.getUserId());
            post.put("rating", rating);
            post.put("review", review);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequester req = new JsonObjectRequester();
        String urlPath = "books/" + bookID + "/addReview";
        req.postRequest(urlPath, post, new VolleyCommand<JSONObject>() {
            @Override
            public void execute(JSONObject data) {
                volleyListener.onReviewSucceeded();
            }

            @Override
            public void onError(VolleyError error) {
                Log.d("Reviews", "Error posting reviews.");
            }
        }, null, null);
    }

    @Override
    public int getBookID() {
        return bookID;
    }
}
