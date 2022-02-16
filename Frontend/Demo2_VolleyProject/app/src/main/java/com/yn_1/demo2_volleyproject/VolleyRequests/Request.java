package com.yn_1.demo2_volleyproject.VolleyRequests;

/**
 * Volley requests interface
 */
public interface Request {

    /**
     * Volley GET Method: <br>
     * For getting request
     */
    void getRequest();

    /**
     * Volley POST Method:
     * For adding requests
     */
    void postRequest();

    /**
     * Volley PUT Method:
     * For changing requests
     */
    void putRequest();

    /**
     * Volley GET Method:
     * For deleting requests
     */
    void deleteRequest();
}
