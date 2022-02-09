package com.example.e3_volley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.e3_volley.app.AppController;
import com.example.e3_volley.net_utils.Const;

import org.json.JSONObject;

public class StringRequestActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        TextView textView = (TextView) findViewById(R.id.stringRequestResponseText);

        String tag_string_req = "string_req";
        String url = Const.URL_STRING_REQ;

        ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        textView.setText("Loading...");
        pDialog.show();

        StringRequest stringRequest =
            new StringRequest(Request.Method.GET, url,
            response -> {
                Log.d(AppController.TAG, response.toString());
                textView.setText("Response:\n" + response.toString());
                pDialog.hide();
            }, error -> {
                VolleyLog.d(AppController.TAG, error.getMessage());
                pDialog.hide();
            });



        AppController.getInstance().addToRequestQueue(stringRequest, tag_string_req);
    }

}
