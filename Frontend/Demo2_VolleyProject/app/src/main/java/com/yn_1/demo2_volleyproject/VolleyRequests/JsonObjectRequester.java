package com.yn_1.demo2_volleyproject.VolleyRequests;

import org.json.JSONObject;

/**
 * Volley JSON object request class.
 *
 * @author Maxim Popov
 */
public class JsonObjectRequester implements Requester<JSONObject> {
    @Override
    public JSONObject getRequest(String url) {
        return null;
    }

    @Override
    public void postRequest(String url, JSONObject post) {

    }

    @Override
    public void putRequest(String url, JSONObject put) {

    }

    @Override
    public void deleteRequest(String url) {

    }
}
