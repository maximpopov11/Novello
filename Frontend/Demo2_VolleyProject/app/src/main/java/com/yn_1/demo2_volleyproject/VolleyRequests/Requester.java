package com.yn_1.demo2_volleyproject.VolleyRequests;

/**
 * Volley requests interface
 */
public interface Requester {

    /**
     * Volley GET Method: <br>
     * For getting request
     */
    Object getRequest(String url);

    /**
     * Volley POST Method:
     * For adding requests
     */
    void postRequest(String url, Object post);

    /**
     * Volley PUT Method:
     * For changing requests
     */
    void putRequest(String url);

    /**
     * Volley GET Method:
     * For deleting requests
     */
    void deleteRequest(String url);
}
