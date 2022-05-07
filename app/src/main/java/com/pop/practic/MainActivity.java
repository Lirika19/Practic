package com.pop.practic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.pop.practic.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        NavHostFragment navHostFragment = activityMainBinding.tabsContainer.getFragment();
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(activityMainBinding.bottomNavigationView, navController);
    }
}