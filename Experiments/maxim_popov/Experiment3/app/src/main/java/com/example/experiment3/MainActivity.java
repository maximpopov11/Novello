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

import com.example.experiment3.ui.main.SectionsPagerAdapter;
import com.example.experiment3.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //initialize books
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("The Final Empire", "Brandon Sanderson", "Mistborn", BookType.Fantasy));
        books.add(new Book("The Well of Ascension", "Brandon Sanderson", "Mistborn", BookType.Fantasy));
        books.add(new Book("The Hero of Ages", "Brandon Sanderson", "Mistborn", BookType.Fantasy));
        books.add(new Book("Warbreaker", "Brandon Sanderson", "Warbreaker", BookType.Fantasy));
        books.add(new Book("Skyward", "Brandon Sanderson", "Skyawrd", BookType.ScienceFiction));
        books.add(new Book("War and Peace", "Leo Tolstoy", "War and Peace", BookType.Classic));

        //todo:
            //give books public rating (general)
            //allow user to choose preference for book type
            //suggest book to user
            //allow user to choose book
            //allow user to rate book
            //suggest other similar books with high ratings to user

    }
}