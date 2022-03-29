package com.yn_1.novello_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yn_1.novello_app.account.AdultUser;

public class NavBarActivity extends AppCompatActivity {

    AdultUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);

        user = (AdultUser) getIntent().getSerializableExtra("USER");

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        NavigationUI.setupWithNavController(bottomNav, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch (destination.getId())
                {
                    case R.id.homeFragment:
                        bottomNav.setVisibility(View.VISIBLE);
                        navController.navigate(R.id.homeFragment);
                        break;
                    case R.id.libraryFragment:
                        bottomNav.setVisibility(View.VISIBLE);
                        navController.navigate(R.id.libraryFragment);
                        break;
                    default:
                        bottomNav.setVisibility(View.GONE);
                        Log.d("Navigation", "Button received error");
                        break;
                }
            }
        });
    }
}