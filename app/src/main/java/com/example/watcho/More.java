package com.example.watcho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class More extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.browse);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.more: return true;
                    case R.id.downloads:
                        startActivity(new Intent(getApplicationContext(), Downloads.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), Search.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.browse:
                        startActivity(new Intent(getApplicationContext(), Browse.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });
    }
}
