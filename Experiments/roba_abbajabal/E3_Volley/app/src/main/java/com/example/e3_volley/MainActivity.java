package com.example.e3_volley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button stringButton = (Button) findViewById(R.id.stringRequestButton);
        Button jsonButton = (Button) findViewById(R.id.jsonRequestButton);
        Button imageButton = (Button) findViewById(R.id.imageRequestButton);

        stringButton.setOnClickListener(view -> switchToStringActivity());
        jsonButton.setOnClickListener(view -> switchToJsonActivity());
        imageButton.setOnClickListener(view -> switchToImageActivity());
    }

    public void switchToStringActivity()
    {
        Intent intent = new Intent(this, StringRequestActivity.class);
        startActivity(intent);
    }

    public void switchToJsonActivity()
    {
        Intent intent = new Intent(this, JsonRequestActivity.class);
        startActivity(intent);
    }

    public void switchToImageActivity()
    {
        Intent intent = new Intent(this, ImageRequestActivity.class);
        startActivity(intent);
    }
}