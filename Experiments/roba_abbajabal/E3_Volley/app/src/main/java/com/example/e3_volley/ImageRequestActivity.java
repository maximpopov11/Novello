package com.example.e3_volley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.example.e3_volley.app.AppController;
import com.example.e3_volley.net_utils.Const;

public class ImageRequestActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        ImageLoader imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView imgNetWorkView = new NetworkImageView(this);
        imgNetWorkView.setImageUrl(Const.URL_IMAGE, imageLoader);

        imageLoader.get(Const.URL_IMAGE, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                if (response.getBitmap() != null)
                {
                    imageView.setImageBitmap(response.getBitmap());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                imageLoader.get(Const.URL_IMAGE, ImageLoader.getImageListener(
                        imageView, R.drawable.gif_loading, R.drawable.ic_error));
            }
        });
    }
}
