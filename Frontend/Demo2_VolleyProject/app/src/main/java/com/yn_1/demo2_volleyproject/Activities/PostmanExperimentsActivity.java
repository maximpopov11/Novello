package com.yn_1.demo2_volleyproject.Activities;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.VolleyError;
import com.yn_1.demo2_volleyproject.Book;
import com.yn_1.demo2_volleyproject.CustomRadioButtonGroup;
import com.yn_1.demo2_volleyproject.R;
import com.yn_1.demo2_volleyproject.VolleyCommand;
import com.yn_1.demo2_volleyproject.VolleyRequesters.JsonArrayRequester;
import com.yn_1.demo2_volleyproject.VolleyRequesters.JsonObjectRequester;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PostmanExperimentsActivity extends AppCompatActivity {

    List<Book> bookCollection = new ArrayList<>();
    TableLayout table;
    CustomRadioButtonGroup radioButtonGroup = new CustomRadioButtonGroup();
    Button removeButton;
    Button changeRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postman_experiments);
        table = findViewById(R.id.PostmanTable);
        retrieveBooks();

        removeButton = findViewById(R.id.removeBook);
        changeRating = findViewById(R.id.changeRating);
        removeButton.setOnClickListener(removeButtonListener);

    }

    /**
     * @author Roba Abbajabal
     */
    public void retrieveBooks() {
        bookCollection = new ArrayList<>();
        table.removeViews(1, table.getChildCount()-1);

        JsonArrayRequester req = new JsonArrayRequester();
        req.getRequest("library/books", null, new VolleyCommand<JSONArray>()
        {
            @Override
            public void execute(JSONArray data) {
                for (int i = 0; i < data.length(); i++)
                {
                    try {
                        JSONObject book = data.getJSONObject(i);
                        int bookID = book.getInt("bookID");
                        String isbn  = book.getString("isbn");
                        String title = book.getString("title");
                        String author = book.getString("author");
                        int rating = book.getInt("rating");
                        putBookOnTable(bookID, title, author, isbn, rating);
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
    public void putBookOnTable(int bookID, String title, String author, String isbn, int rating) {

        Book book = new Book(bookID, title, author, -1, isbn, rating);
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
        radioButtonGroup.addButtonToGroup(selectButton);
        selectButton.setOnClickListener(radioButtonGroup.listener);

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

    /**
     *
     * @param book
     * @author Roba Abbajabal
     */
    private void deleteBookFromLibrary(Book book) {
        JSONObject bookToRemove = new JSONObject();
        try {
            bookToRemove.put("bookID", book.getISBN());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequester requester = new JsonObjectRequester();
        requester.deleteRequest("book/"+book.getISBN(), null, new VolleyCommand<JSONObject>() {
            @Override
            public void execute(JSONObject data) { }

            @Override
            public void onError(VolleyError error) {
                Log.e(requester.TAG, "Error on delete: Book not found.");
            }
        }, null, null);
    }

    public View.OnClickListener removeButtonListener = v -> {
        RadioButton chosenButton = null;
        for (RadioButton button : radioButtonGroup.getButtonCollection()) {
            if (button.isChecked()) {
                chosenButton = button;
            }
        }
        if (chosenButton == null) {
            return;
        }

        // Gets the title, removes book at title (index 1 should be where the text view is located)
        String theTitle = ((TextView)((ViewGroup)chosenButton.getParent()).getChildAt(1)).getText().toString();
        // Gets the title, removes the book
        for (Book book : bookCollection) {
            if (book.getTitle() == theTitle) {
                deleteBookFromLibrary(book);
                retrieveBooks();
            }
        }
        // table.removeView((View)chosenButton.getParent()); //Directly removes row
    };
}
