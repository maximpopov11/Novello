package com.yn_1.novello_app.account;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.cart.CartPresenter;
import com.yn_1.novello_app.volley_requests.JsonArrayRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Profile screen model.
 */
public class ProfileModel {

    ProfilePresenter presenter;

    User user;

    /**
     * Constructor
     * Creates a presenter
     */
    public ProfileModel(ProfilePresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Sets the user
     * @param user current user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Receives the friends list from the database
     */
    public void getFriendsList() {
        JsonArrayRequester jsonArrayRequester = new JsonArrayRequester();
        JsonArrayCommand command = new JsonArrayCommand();
        JSONArray userJson = new JSONArray();
        try {
            JSONObject jsonElement = new JSONObject();
            jsonElement.put("id", user.getUserId());
            userJson.put(jsonElement);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArrayRequester.getRequest("friends", userJson, command, null, null);
    }

    /**
     * Sends friends list to presenter
     * @param friendsList is the user's friend list
     */
    private void setFriendsList(ArrayList<User> friendsList) {
        presenter.setFriendsList(friendsList);
    }

    /**
     * Class used to get result of request
     */
    private class JsonArrayCommand implements VolleyCommand<JSONArray> {

        @Override
        public void execute(JSONArray data) {
            //todo: parse data into ArrayList and call setFriendsList with that as a param
        }

        @Override
        public void onError(VolleyError error) {

        }

    }

}
