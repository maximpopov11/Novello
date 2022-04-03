package com.yn_1.novello_app.discovery;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.volley_requests.JsonArrayRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONArray;

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
        //todo: test request
        allBooksRequester.getRequest("library", null, command, null, null);

    }

    /**
     * Sends received books to presenter.
     * @param data
     */
    private void sendBooksToPresenter(JSONArray data) {
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
