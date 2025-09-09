package com.acer083.infogram.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;


import com.acer083.infogram.R;
import com.acer083.infogram.view.fragment.HomeFragment;
import com.acer083.infogram.view.fragment.ProfileFragment;
import com.acer083.infogram.view.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ConteinerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_conteiner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Fragment selectdFragment = null;
                        if (menuItem.getItemId() == R.id.search ){
                                selectdFragment = new SearchFragment();
                        } else if (menuItem.getItemId() == R.id.home){
                            selectdFragment = new HomeFragment();
                        }  else if (menuItem.getItemId() == R.id.profile){
                            selectdFragment = new ProfileFragment();
                        }

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.conteiner_frame, selectdFragment)
                                .commit();
                        return true;
                    }
                }
        );
    }
}