package com.yn_1.novello_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.home.HomeFragment;
import com.yn_1.novello_app.library.LibraryFragment;
import com.yn_1.novello_app.account.AdultUser;

import java.util.List;

public class NavBarActivity extends AppCompatActivity {

    private AdultUser user;
    private NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);

        // Server: Gets user from LoginActivity
        // user = (AdultUser) getIntent().getSerializableExtra("USER");

        // Postman: Used for individual testing
        user = new AdultUser("testUser", null, -1);

        NavHostFragment host = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        controller = host.getNavController();

        BottomNavigationView navBar = findViewById(R.id.bottom_nav);
        NavigationUI.setupWithNavController(navBar, controller);


        navBar.setOnItemSelectedListener (
                item -> {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();

                    switch (item.getItemId()) {
                        case R.id.homeFragment:
                            transaction.replace(R.id.nav_host_fragment, new HomeFragment()).commit();
                            return true;

                        case R.id.libraryFragment:
                            transaction.replace(R.id.nav_host_fragment, new LibraryFragment()).commit();
                            return true;

                        default:
                            return false;
                    }
                }
        );
    }

    public User getUser() {
        return user;
    }

    public NavController getController() {return controller; }
}