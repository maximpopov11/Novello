package com.example.experiment5;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.experiment5.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    int colorInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.show();
        ImageView image1 = new ImageView(this);
        image1.setImageResource(R.drawable.ic_launcher_foreground);
        if (colorInt == 0) {
            image1.setBackgroundColor(Color.BLUE);
        }
        else if (colorInt == 1) {
            image1.setBackgroundColor(Color.BLACK);
        }
        else if (colorInt == 2) {
            image1.setBackgroundColor(Color.CYAN);
        }
        else if (colorInt == 3) {
            image1.setBackgroundColor(Color.DKGRAY);
        }
        else if (colorInt == 4) {
            image1.setBackgroundColor(Color.RED);
        }
        else if (colorInt == 5) {
            image1.setBackgroundColor(Color.GRAY);
        }
        else if (colorInt == 6) {
            image1.setBackgroundColor(Color.GREEN);
        }
        else if (colorInt == 7) {
            image1.setBackgroundColor(Color.LTGRAY);
        }
        else if (colorInt == 8) {
            image1.setBackgroundColor(Color.MAGENTA);
        }
        else if (colorInt == 9) {
            image1.setBackgroundColor(Color.TRANSPARENT);
        }
        else if (colorInt == 10) {
            image1.setBackgroundColor(Color.WHITE);
        }
        else if (colorInt == 11) {
            image1.setBackgroundColor(Color.YELLOW);
        }
        colorInt++;
        if (colorInt > 11) {
            colorInt = 0;
        }
    }
}