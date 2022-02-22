package com.yn_1.demo2_volleyproject.VolleyRequests;

import android.media.Image;

import com.yn_1.demo2_volleyproject.VolleyCommand;

import java.util.Map;

/**
 * Volley image request class.
 *
 * @author Roba Abbajabal
 */
public class ImageRequester implements Requester<Image> {
    @Override
    public void getRequest(String url, VolleyCommand command,
                            Map<String, String> headers, Map<String, String> params) {

    }

    @Override
    public void postRequest(String url, Image post, VolleyCommand command,
                            Map<String, String> headers, Map<String, String> params) {

    }

    @Override
    public void putRequest(String url, Image put, VolleyCommand command,
                           Map<String, String> headers, Map<String, String> params) {

    }

    @Override
    public void deleteRequest(String url, VolleyCommand command,
                              Map<String, String> headers, Map<String, String> params) {

    }
}
