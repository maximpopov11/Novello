package com.yn_1.novello_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.account.AdultUser;

public class NavBarActivity extends AppCompatActivity {

    private AdultUser user;
    private NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);

        // Server: Gets user from LoginActivity
        // user = (AdultUser) getIntent().getSerializableExtra("USER");
        user = getIntent().getParcelableExtra("USER");

        // Postman: Used for individual testing
        // user = new AdultUser("testUser", null, -1);

        NavHostFragment host = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        controller = host.getNavController();

        BottomNavigationView navBar = findViewById(R.id.bottom_nav);
        NavigationUI.setupWithNavController(navBar, controller);

        navBar.setOnItemSelectedListener (
                item -> {
                    switch (item.getItemId()) {
                        case R.id.homeFragment:
                            controller.navigate(R.id.homeFragment);
                            return true;

                        case R.id.libraryFragment:
                            controller.navigate(R.id.libraryFragment);
                            return true;

                        case R.id.cartView:
                            controller.navigate(R.id.cartView);
                            return true;

                        case R.id.discoverView:
                            controller.navigate(R.id.discoverView);
                            return true;

                        case R.id.chatFragment:
                            controller.navigate(R.id.chatFragment);
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