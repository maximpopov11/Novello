package com.yn_1.demo2_volleyproject.VolleyRequests;

import com.yn_1.demo2_volleyproject.VolleyCommand;

import org.json.JSONObject;

import java.util.Map;

/**
 * Volley JSON object request class.
 *
 * @author Maxim Popov
 */
public class JsonObjectRequester implements Requester<JSONObject> {
    @Override
    public void getRequest(String url, VolleyCommand command,
                                 Map<String, String> headers, Map<String, String> params) {

    }

    @Override
    public void postRequest(String url, JSONObject post, VolleyCommand command,
                            Map<String, String> headers, Map<String, String> params) {

    }

    @Override
    public void putRequest(String url, JSONObject put, VolleyCommand command,
                           Map<String, String> headers, Map<String, String> params) {

    }

    @Override
    public void deleteRequest(String url, VolleyCommand command,
                              Map<String, String> headers, Map<String, String> params) {

    }
}
