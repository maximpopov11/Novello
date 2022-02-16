package com.yn_1.demo2_volleyproject.VolleyRequests;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.yn_1.demo2_volleyproject.AppController;
import org.json.JSONException;
import java.util.HashMap;
import java.util.Map;

/**
 * Volley JSON array request class.
 *
 * @author Roba Abbajabal
 */
public class JsonArrayRequester implements Requester {

    public static final String TAG="json_array_req";

    @Override
    public Map<Integer, String> getRequest(String url) {
        Map<Integer, String> returnValue = new HashMap<Integer, String>();
        JsonArrayRequest getJsonArrayRequest = new JsonArrayRequest(
            Request.Method.GET, url, null,
            response -> {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        returnValue.put(i, response.get(i).toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, error -> {
                error.printStackTrace();
            });
        AppController.getInstance().addToRequestQueue(getJsonArrayRequest, TAG);
        return returnValue;
    }

    @Override
    public void postRequest(String url, Object object) {
        JsonArrayRequest getJsonArrayRequest = new JsonArrayRequest(
            Request.Method.POST, url, null,
            response -> {
                // Do something
            }, error -> {
                // Do Something
            });
        AppController.getInstance().addToRequestQueue(getJsonArrayRequest, TAG);
    }

    @Override
    public void putRequest(String url) {
        JsonArrayRequest getJsonArrayRequest = new JsonArrayRequest(
            Request.Method.PUT, url, null,
            response -> {
                // Do Something
            }, error -> {
                // Do Something
            });
        AppController.getInstance().addToRequestQueue(getJsonArrayRequest, TAG);
    }

    @Override
    public void deleteRequest(String url) {
        JsonArrayRequest getJsonArrayRequest = new JsonArrayRequest(
            Request.Method.DELETE, url, null,
            response -> {
                // Do something
            }, error -> {
                // Do Something
            });
        AppController.getInstance().addToRequestQueue(getJsonArrayRequest, TAG);
    }
}
