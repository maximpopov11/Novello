package com.example.e3_volley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.e3_volley.app.AppController;
import com.example.e3_volley.net_utils.Const;

public class JsonRequestActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        String tag_json_req = "json_obj_req";
        String url = Const.URL_JSON_OBJECT;

        ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonObjectRequest jsonObjectRequest =
            new JsonObjectRequest(Request.Method.GET, url, null,
            response -> {
                Log.d(AppController.TAG, response.toString());
                pDialog.hide();
            }, error -> {
                VolleyLog.d(AppController.TAG, error.getMessage());
                pDialog.hide();
            });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest, tag_json_req);
    }
}
