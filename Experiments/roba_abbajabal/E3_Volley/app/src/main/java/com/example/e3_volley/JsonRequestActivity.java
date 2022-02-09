package com.example.e3_volley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.e3_volley.app.AppController;
import com.example.e3_volley.net_utils.Const;

public class JsonRequestActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        TextView textView = (TextView) findViewById(R.id.jsonResponseText);

        String tag_json_obj_req = "json_obj_req";
        String tag_json_array_req = "json_array_req";
        String object_url = Const.URL_JSON_OBJECT;
        String array_url = Const.URL_JSON_ARRAY;

        ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        textView.setText("Loading...");

        pDialog.show();

        JsonObjectRequest jsonObjectRequest =
            new JsonObjectRequest(Request.Method.GET, object_url, null,
            response -> {
                Log.d(AppController.TAG, response.toString());
                textView.setText("Object Reponse:\n" + response.toString());
                pDialog.hide();
            }, error -> {
                VolleyLog.d(AppController.TAG, error.getMessage());
                pDialog.hide();
            });

        JsonArrayRequest jsonArrayRequest =
            new JsonArrayRequest(Request.Method.GET, array_url, null,
            response -> {
                Log.d(AppController.TAG, response.toString());
                    textView.setText(textView.getText()+"\nArray Reponse:\n" + response.toString());
                    pDialog.hide();
            }, error -> {
                VolleyLog.d(AppController.TAG, error.getMessage());
                pDialog.hide();
            });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest, tag_json_obj_req);
        AppController.getInstance().addToRequestQueue(jsonArrayRequest, tag_json_array_req);
    }
}
