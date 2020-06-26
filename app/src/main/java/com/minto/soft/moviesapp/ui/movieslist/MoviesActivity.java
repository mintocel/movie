package com.minto.soft.moviesapp.ui.movieslist;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.minto.soft.moviesapp.LoadingActivity;
import com.minto.soft.moviesapp.R;
import com.minto.soft.moviesapp.ui.movieslist.favorites.FavoritesFragment;
import com.minto.soft.moviesapp.ui.movieslist.popular.PopularMoviesFragment;
import com.minto.soft.moviesapp.utils.ActivityUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
public class MoviesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            Intent intent = new Intent(this, LoadingActivity.class);
            startActivity(intent);
            setupViewFragment();
        }
        setupToolbar();
        ActivityUtils.replaceFragmentInActivity(
                getSupportFragmentManager(), PopularMoviesFragment.newInstance(),
                R.id.fragment_container);
        setupBottomNavigation();
    }
    private void setupViewFragment() {
        // show discover movies fragment by default
        PopularMoviesFragment popularMoviesFragment = PopularMoviesFragment.newInstance();
        ActivityUtils.replaceFragmentInActivity(
                getSupportFragmentManager(), popularMoviesFragment, R.id.fragment_container);
    }

    private void setupBottomNavigation() {
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_discover:
                        ActivityUtils.replaceFragmentInActivity(
                                getSupportFragmentManager(), PopularMoviesFragment.newInstance(),
                                R.id.fragment_container);
                        return true;
                    case R.id.action_favorites:
                        ActivityUtils.replaceFragmentInActivity(
                                getSupportFragmentManager(), FavoritesFragment.newInstance(),
                                R.id.fragment_container);
                        return true;
                }
                return false;
            }
        });
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
