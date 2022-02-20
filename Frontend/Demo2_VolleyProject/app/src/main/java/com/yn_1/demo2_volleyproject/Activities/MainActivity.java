package com.yn_1.demo2_volleyproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yn_1.demo2_volleyproject.Book;
import com.yn_1.demo2_volleyproject.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView showSearched;
    TextView selectedBook;
    String searchedTitle;
    EditText stringInput;
    Button submitSearchButton;

    ArrayList<Book> library = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateLibrary();

        stringInput = (EditText) findViewById(R.id.searchBookTitle);
        stringInput.setHint("Input book title...");
        showSearched = (TextView) findViewById(R.id.showSearched);
        submitSearchButton = (Button) findViewById(R.id.submitSearch);
        submitSearchButton.setText("Submit");
        submitSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchedTitle = stringInput.getText().toString();
                showSearched.setText("Searched for " + searchedTitle + "!");
                Book searchedBook = searchLibrary(searchedTitle);
                if (searchedBook != null) {
                    selectedBook.setText(searchedBook.toString());
                }
                else {
                    selectedBook.setText(searchedTitle + " not found in library.");
                }
            }
        });

    }

    private void populateLibrary() {

        library.add(new Book("Mistborn", "Brandon Sanderson", 2006, "9780765311788", 5.0));
        library.add(new Book("Roba's Autobiography", "Roba", 2022, "3", 5.1));
        library.add(new Book("Life of Kevin", "Kyle", 2022, "7", 2.2));
        library.add(new Book("Life of Kyle", "Other Kyle", 2022, "number", 4.3));

    }

    private Book searchLibrary(String title) {

        Book searching = null;
        for (int i = 0; i < library.size(); i++) {
            Book candidate = library.get(i);
            if (candidate.getTitle().equals(title)) {
                searching = candidate;
                break;
            }
        }
        return searching;

    }

}