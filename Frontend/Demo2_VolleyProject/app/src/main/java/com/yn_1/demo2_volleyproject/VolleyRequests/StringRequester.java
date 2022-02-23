package com.yn_1.demo2_volleyproject.VolleyRequests;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.yn_1.demo2_volleyproject.AppController;
import com.yn_1.demo2_volleyproject.VolleyCommand;

import java.util.Map;

/**
 * Volley string request class.
 *
 * @author Maxim Popov
 */
public class StringRequester implements Requester<String> {

    // Request tag for debugging.
    public static final String TAG="json_array_req";

    @Override
    public void getRequest(String url, VolleyCommand command,
                             Map<String, String> headers, Map<String, String> params) {
        StringRequest getStringRequest = new StringRequest(
                Request.Method.GET, url, null,
                response -> {
                    Log.d(TAG, response.toString());
                    command.execute(response);
                }, error -> {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers == null) {
                    return super.getHeaders();
                }
                else {
                    return headers;
                }
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (headers == null) {
                    return super.getParams();
                }
                else {
                    return headers;
                }
            }
        };
        AppController.getInstance().addToRequestQueue(getStringRequest, TAG);
    }

    @Override
    public void postRequest(String url, String post, VolleyCommand command,
                            Map<String, String> headers, Map<String, String> params) {
        StringRequest postStringRequest = new StringRequest(
                Request.Method.POST, url, post,
                response -> {
                    Log.d(TAG, response.toString());
                    command.execute(response);
                }, error -> {
            VolleyLog.d(TAG, "Error: " + error.getMessage());
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers == null)
                    return super.getHeaders();
                else
                    return headers;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (headers == null)
                    return super.getParams();
                else
                    return headers;
            }
        };
        AppController.getInstance().addToRequestQueue(postStringRequest, TAG);
    }

    @Override
    public void putRequest(String url, String put, VolleyCommand command,
                           Map<String, String> headers, Map<String, String> params) {
        StringRequest putStringRequest = new StringRequest(
                Request.Method.PUT, url, put,
                response -> {
                    Log.d(TAG, response.toString());
                    command.execute(response);
                }, error -> {
            VolleyLog.d(TAG, "Error: " + error.getMessage());
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers == null)
                    return super.getHeaders();
                else
                    return headers;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (headers == null)
                    return super.getParams();
                else
                    return headers;
            }
        };
        AppController.getInstance().addToRequestQueue(putStringRequest, TAG);
    }

    @Override
    public void deleteRequest(String url, VolleyCommand command,
                              Map<String, String> headers, Map<String, String> params) {
        StringRequest deleteStringRequest = new StringRequest(
                Request.Method.DELETE, url, null,
                response -> {
                    Log.d(TAG, response.toString());
                    command.execute(response);
                }, error -> {
            VolleyLog.d(TAG, "Error: " + error.getMessage());
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers == null)
                    return super.getHeaders();
                else
                    return headers;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (headers == null)
                    return super.getParams();
                else
                    return headers;
            }
        };
        AppController.getInstance().addToRequestQueue(deleteStringRequest, TAG);
    }

}
