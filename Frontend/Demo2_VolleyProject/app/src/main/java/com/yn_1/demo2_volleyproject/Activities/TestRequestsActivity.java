package com.yn_1.demo2_volleyproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.yn_1.demo2_volleyproject.R;
import com.yn_1.demo2_volleyproject.VolleyCommand;
import com.yn_1.demo2_volleyproject.VolleyRequests.ImageRequester;
import com.yn_1.demo2_volleyproject.VolleyRequests.JsonArrayRequester;

import org.json.JSONArray;

public class TestRequestsActivity extends AppCompatActivity {

    public static TextView testView;
    public static ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        testView = findViewById(R.id.testView);
        testView.setText("Loading...");
        imageView = findViewById(R.id.imageView2);


        JsonArrayRequester requester = new JsonArrayRequester();
        JsonArrayTestCommand jsonArrayTestCommand = new JsonArrayTestCommand();
        requester.getRequest("https://api.androidhive.info/volley/person_array.json", jsonArrayTestCommand, null, null);

        ImageRequester requester2 = new ImageRequester();
        ImageTestCommand imageTestCommand = new ImageTestCommand();
        requester2.getRequest("https://api.androidhive.info/volley/volley-image.jpg", imageTestCommand, null, null);

    }

    class JsonArrayTestCommand implements VolleyCommand<JSONArray> {
        @Override
        public void execute(JSONArray data) {
            testView.setText(data.toString());
        }
    }

    class ImageTestCommand implements VolleyCommand<Bitmap> {
        @Override
        public void execute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }
}