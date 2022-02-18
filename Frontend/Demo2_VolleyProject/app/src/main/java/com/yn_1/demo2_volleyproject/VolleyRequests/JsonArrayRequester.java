package com.yn_1.demo2_volleyproject.VolleyRequests;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.yn_1.demo2_volleyproject.AppController;
import org.json.JSONArray;

/**
 * Volley JSON array request class.
 *
 * @author Roba Abbajabal
 */
public class JsonArrayRequester implements Requester<JSONArray> {

    public static final String TAG="json_array_req";

    private JSONArray receivedArray;
    @Override
    public JSONArray getRequest(String url) {
        JsonArrayRequest getJsonArrayRequest = new JsonArrayRequest(
            Request.Method.GET, url, null,
            response -> {
                receivedArray = response;
            }, error -> {
                receivedArray = null;
                error.printStackTrace();
            });
        AppController.getInstance().addToRequestQueue(getJsonArrayRequest, TAG);
        return receivedArray;
    }

    @Override
    public void postRequest(String url, JSONArray post) {
        JsonArrayRequest postJsonArrayRequest = new JsonArrayRequest(
            Request.Method.POST, url, null,
            response -> {
                response.put(post);
            }, error -> {
                error.printStackTrace();
            });
        AppController.getInstance().addToRequestQueue(postJsonArrayRequest, TAG);
    }

    @Override
    public void putRequest(String url, JSONArray put) {
        JsonArrayRequest putJsonArrayRequest = new JsonArrayRequest(
            Request.Method.POST, url, null,
            response -> {
                response.put(put);
            }, error -> {
                error.printStackTrace();
            });
        AppController.getInstance().addToRequestQueue(putJsonArrayRequest, TAG);
    }

    @Override
    public void deleteRequest(String url) {
        JsonArrayRequest deleteJsonArrayRequest = new JsonArrayRequest(
            Request.Method.DELETE, url, null,
            response -> {
                // Something
            }, error -> {
                error.printStackTrace();
            });
        AppController.getInstance().addToRequestQueue(deleteJsonArrayRequest, TAG);
    }
}
