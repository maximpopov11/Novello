package com.example.experiment3;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.experiment3.ui.main.SectionsPagerAdapter;
import com.example.experiment3.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    BookType preferred;
    ArrayList<Book> books;
    Button fantasy;
    Button scifi;
    Button classic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        TabLayout tabs = binding.tabs;
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //initialize books
        books = new ArrayList<>();
        books.add(new Book("The Final Empire", "Brandon Sanderson", "Mistborn", BookType.Fantasy, 5.0));
        books.add(new Book("The Well of Ascension", "Brandon Sanderson", "Mistborn", BookType.Fantasy, 4.5));
        books.add(new Book("The Hero of Ages", "Brandon Sanderson", "Mistborn", BookType.Fantasy, 4.6));
        books.add(new Book("Warbreaker", "Brandon Sanderson", "Warbreaker", BookType.Fantasy, 4.4));
        books.add(new Book("Skyward", "Brandon Sanderson", "Skyward", BookType.ScienceFiction, 4.1));
        books.add(new Book("War and Peace", "Leo Tolstoy", "War and Peace", BookType.Classic, 1.0));

        fantasy= (Button) findViewById(R.id.fantasy);
        scifi = (Button) findViewById(R.id.scifi);
        classic = (Button) findViewById(R.id.classic);
        fantasy.setText("Fantasy!");
        scifi.setText("Sci Fi");
        classic.setText("Classic :(");
        fantasy.setOnClickListener(view -> selectPreferred(BookType.Fantasy));
        scifi.setOnClickListener(view -> selectPreferred(BookType.ScienceFiction));
        classic.setOnClickListener(view -> selectPreferred(BookType.Classic));

    }

    private void selectPreferred(BookType type) {
        this.preferred = type;

        Book suggested = books.get(0);
        for (int i = 0; i < books.size(); i++) {
            boolean better = false;
            Book candidate = books.get(i);
            if (candidate.type == preferred && suggested.type != preferred) {
                better = true;
            }
            else if (candidate.rating > suggested.rating) {
                better = true;
            }
            if (better) {
                suggested = candidate;
            }
        }

        TextView recommendation = (TextView) findViewById(R.id.Suggestion);
        recommendation.setText("You should read " + suggested.toString() + "!");
    }

}