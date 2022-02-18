package com.yn_1.demo2_volleyproject.VolleyRequests;

/**
 * Volley requests interface
 */
public interface Requester<E> {

    /**
     * Volley GET Method: <br>
     * For getting request
     */
    E getRequest(String url);

    /**
     * Volley POST Method:
     * For adding requests
     */
    void postRequest(String url, E post);

    /**
     * Volley PUT Method:
     * For changing requests
     */
    void putRequest(String url, E put);

    /**
     * Volley DELETE Method:
     * For deleting requests
     */
    void deleteRequest(String url);
}
