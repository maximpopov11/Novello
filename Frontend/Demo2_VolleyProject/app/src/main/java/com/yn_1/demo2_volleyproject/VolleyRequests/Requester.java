package com.yn_1.demo2_volleyproject.VolleyRequests;

import com.yn_1.demo2_volleyproject.VolleyCommand;

import java.util.Map;

/**
 * Volley requests interface
 */
public interface Requester<E> {

    /**
     * Volley GET Method: <br>
     * For requesting a value to get from the server.
     */
    void getRequest(String url, VolleyCommand command,
                 Map<String, String> headers, Map<String, String> params);

    /**
     * Volley POST Method: <br>
     * For requesting a value to add to the server.
     *
     * @param url URL to the request
     * @param post Object to post
     * @param command Command to run upon a response
     * @param headers Headers for the request
     * @param params Parameters for the request
     */
    void postRequest(String url, E post, VolleyCommand command,
                     Map<String, String> headers, Map<String, String> params);

    /**
     * Volley PUT Method: <br>
     * For requesting a value to change in the server.
     *
     * @param url URL to the request
     * @param put Object to put
     * @param command Command to run upon a response
     * @param headers Headers for the request
     * @param params Parameters for the request
     */
    void putRequest(String url, E put, VolleyCommand command,
                    Map<String, String> headers, Map<String, String> params);

    /**
     * Volley DELETE Method: <br>
     * For requesting a value to delete from the server.
     *
     * @param url URL to the request
     * @param command Command to run upon a response
     * @param headers Headers for the request
     * @param params Parameters for the request
     */
    void deleteRequest(String url, VolleyCommand command,
                       Map<String, String> headers, Map<String, String> params);
}
