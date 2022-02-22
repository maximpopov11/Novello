package com.yn_1.demo2_volleyproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.yn_1.demo2_volleyproject.AppController;
import com.yn_1.demo2_volleyproject.R;
import com.yn_1.demo2_volleyproject.VolleyCommand;
import com.yn_1.demo2_volleyproject.VolleyRequests.JsonArrayRequester;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestRequestsActivity extends AppCompatActivity {

    public static TextView testView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Log.d("TestActivity", "Test Activity Started");
        testView = findViewById(R.id.testView);
        testView.setText("Loading...");

        JsonArrayRequester requester = new JsonArrayRequester();
        TestCommand testCommand = new TestCommand();
        requester.getRequest("https://api.androidhive.info/volley/person_array.json", testCommand, null, null);
    }

    class TestCommand implements VolleyCommand<JSONArray> {
        @Override
        public void execute(JSONArray data) {
            testView.setText(data.toString());
        }
    }
}