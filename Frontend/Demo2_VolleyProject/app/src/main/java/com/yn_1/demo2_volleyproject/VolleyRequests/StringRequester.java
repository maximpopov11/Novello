package com.yn_1.demo2_volleyproject.VolleyRequests;

import com.yn_1.demo2_volleyproject.VolleyCommand;

import java.util.Map;

/**
 * Volley string request class.
 *
 * @author Maxim Popov
 */
public class StringRequester implements Requester<String> {
    @Override
    public void getRequest(String url, VolleyCommand command,
                             Map<String, String> headers, Map<String, String> params) {

    }

    @Override
    public void postRequest(String url, String post, VolleyCommand command,
                            Map<String, String> headers, Map<String, String> params) {

    }

    @Override
    public void putRequest(String url, String put, VolleyCommand command,
                           Map<String, String> headers, Map<String, String> params) {

    }

    @Override
    public void deleteRequest(String url, VolleyCommand command,
                              Map<String, String> headers, Map<String, String> params) {

    }
}
