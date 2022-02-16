package com.yn_1.demo2_volleyproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yn_1.demo2_volleyproject.R;

public class MainActivity extends AppCompatActivity {

    TextView searchBar;
    EditText input;
    String searched;
    Button submitSearchButton;
    TextView showSearched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBar = findViewById(R.id.searchBookTitle);
        searchBar.setHint("Enter book title...");
        submitSearchButton = findViewById(R.id.submitSearch);
        submitSearchButton.setText("Submit");
        submitSearchButton.setOnClickListener(v -> {
            //todo: crashes on next line because input is not set to what the user inputted
            searched = input.getText().toString();
            showSearched.setText(input.getText());
        });
        showSearched = findViewById(R.id.showSearched);

    }

}