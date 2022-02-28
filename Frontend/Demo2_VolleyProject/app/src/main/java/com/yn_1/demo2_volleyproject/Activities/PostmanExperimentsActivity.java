package com.yn_1.demo2_volleyproject.Activities;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.VolleyError;
import com.yn_1.demo2_volleyproject.Book;
import com.yn_1.demo2_volleyproject.R;
import com.yn_1.demo2_volleyproject.VolleyCommand;
import com.yn_1.demo2_volleyproject.VolleyRequesters.JsonArrayRequester;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PostmanExperimentsActivity extends AppCompatActivity {

    List<Book> bookCollection = new ArrayList<Book>();
    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postman_experiments);
        table = findViewById(R.id.PostmanTable);
        retrieveBooks();
    }

    /**
     * @author Roba Abbajabal
     */
    public void retrieveBooks() {
        JsonArrayRequester req = new JsonArrayRequester();
        req.getRequest("library/books", null, new VolleyCommand<JSONArray>()
        {
            @Override
            public void execute(JSONArray data) {
                for (int i = 0; i < data.length(); i++)
                {
                    try {
                        JSONObject book = data.getJSONObject(i);
                        String isbn  = book.getString("ISBN");
                        String title = book.getString("title");
                        String author = book.getString("author");
                        int rating = book.getInt("rating");
                        putBookOnTable(isbn, title, author, rating);
                        Log.d("Retrieve books", "Works");
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(VolleyError error) {

            }
        }, null, null);
    }

    /**
     * Dynamically creates a row to put a book on
     * @param title
     * @param author
     * @param rating
     * @author Roba Abbajabal
     */
    public void putBookOnTable(String isbn, String title, String author, int rating) {
        Book book = new Book(title, author, -1, isbn, rating);
        bookCollection.add(book);
        TableRow bookRow = new TableRow(this);
        bookRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
        bookRow.setBackgroundColor(Color.WHITE);

        RadioButton selectButton = new RadioButton(this);
        selectButton.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
        selectButton.setPadding(0, 10,0,10);
        selectButton.setChecked(false);
        // Credit for ColorStateList: https://stackoverflow.com/a/29551017/10818632
        ColorStateList temp = new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled},
                new int[]{android.R.attr.state_enabled}}, new int[]{Color.BLACK, Color.BLUE});
        selectButton.setButtonTintList(temp);
        selectButton.setText(null);
        bookRow.addView(selectButton);

        TextView titleText = new TextView(this);
        titleText.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 4));
        titleText.setPadding(10, 10,10,10);
        titleText.setGravity(TextView.TEXT_ALIGNMENT_CENTER);
        titleText.setText(book.getTitle());
        titleText.setTextColor(Color.BLACK);
        titleText.setTextSize(14);
        bookRow.addView(titleText);

        TextView authorText = new TextView(this);
        authorText.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 4));
        authorText.setPadding(10, 10,10,10);
        authorText.setGravity(TextView.TEXT_ALIGNMENT_CENTER);
        authorText.setText(book.getAuthor());
        authorText.setTextColor(Color.BLACK);
        authorText.setTextSize(14);
        bookRow.addView(authorText);

        RatingBar ratingBar = new RatingBar(this);
        ratingBar.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        ratingBar.setPadding(0, 0,0,0);
        ratingBar.setRating(rating);
        ratingBar.setScaleX(.3f);
        ratingBar.setScaleY(.3f);
        bookRow.addView(ratingBar);

        table.addView(bookRow);
    }
}
