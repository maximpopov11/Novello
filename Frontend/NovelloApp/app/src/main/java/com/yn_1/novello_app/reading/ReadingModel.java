package com.yn_1.novello_app.reading;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.volley_requests.JsonObjectRequester;
import com.yn_1.novello_app.volley_requests.StringRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ReadingModel implements ReadingContract.Model {

    private int bookID;
    private String pageURL;

    public ReadingModel(int bookID, String pageURL) {
        this.bookID = bookID;
        this.pageURL = pageURL;
    }

    @Override
    public void fetchProgress(User user, int bookID, ReadingContract.View view) {
        JsonObjectRequester req = new JsonObjectRequester();
        JSONObject object = new JSONObject();
        try {
            object.put("bookId", bookID);
            object.put("userId", user.getUserId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        req.getRequest( "bookData",
            object, new VolleyCommand<JSONObject>() {
                @Override
                public void execute(JSONObject data) {
                    int progress = 0;
                    try {
                        progress = data.getInt("page");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    view.jumpToProgress(progress);
                }

                @Override
                public void onError(VolleyError error) {

                }
            }, null, null);
    }

    @Override
    public void saveProgress(User user, int bookID, int progress) {
        JsonObjectRequester req = new JsonObjectRequester();

        JSONObject object = new JSONObject();
        try {
            object.put("bookId", bookID);
            object.put("userId", user.getUserId());
            object.put("page", progress);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        req.putRequest("bookData",
                object, new VolleyCommand<String>() {
                    @Override
                    public void execute(String data) {

                    }

                    @Override
                    public void onError(VolleyError error) {

                    }
                }, null, null);
    }

    @Override
    public int getBookId() {
        return bookID;
    }

    @Override
    public String getUrl() {
        return pageURL;
    }
}
