package com.yn_1.novello_app.reading;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.volley_requests.StringRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

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
        StringRequester req = new StringRequester();
        req.getRequest(user.getUserId() + "/library/currentlyReading" + bookID,
            null, new VolleyCommand<String>() {
                @Override
                public void execute(String data) {
                    int progress = Integer.getInteger(data);
                    view.jumpToProgress(progress);
                }

                @Override
                public void onError(VolleyError error) {

                }
            }, null, new HashMap<String, String>() {{
                    put("user_id", String.valueOf(user.getUserId()));
                    put("book_id", String.valueOf(bookID));
                }
            });
    }

    @Override
    public void saveProgress(User user, int bookID, int progress) {
        StringRequester req = new StringRequester();
        req.getRequest(user.getUserId() + "/library/currentlyReading" + bookID,
                String.valueOf(progress), new VolleyCommand<String>() {
                    @Override
                    public void execute(String data) {
                        int progress = Integer.getInteger(data);
                    }

                    @Override
                    public void onError(VolleyError error) {

                    }
                }, null, new HashMap<String, String>() {{
                    put("user_id", String.valueOf(user.getUserId()));
                    put("book_id", String.valueOf(bookID));
                }
                });
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
