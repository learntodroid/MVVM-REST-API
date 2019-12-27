package com.learntodroid.mvvmrestapi.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.learntodroid.mvvmrestapi.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        NavController navController = Navigation.findNavController(this, R.id.activity_main_navhostfragment);
//        BottomNavigationView bottomNavigation = findViewById(R.id.activity_main_bottomnavigation);
//        NavigationUI.setupWithNavController(bottomNavigation, navController);
    }
}
