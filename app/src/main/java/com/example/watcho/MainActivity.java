package com.example.watcho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {


    CarouselView carouselView;
    ImageView show;

    int[] sampleImages = {R.drawable.grp_1, R.drawable.grp_2, R.drawable.grp_3, R.drawable.grp_4};
  //  Button split_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setLogo(R.drawable.watcho_logo);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SplitScreen();
            }
        });

        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home: return true;
                    case R.id.downloads:
                        startActivity(new Intent(getApplicationContext(), Downloads.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.browse:
                        startActivity(new Intent(getApplicationContext(), Browse.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), Search.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.more:
                        startActivity(new Intent(getApplicationContext(), More.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });


        show = findViewById(R.id.img_show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Videoview.class);
                startActivity(i);
            }
        });
    }
    private void SplitScreen() {


        Intent i = new Intent(MainActivity.this, Downloads.class);
        i.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT|
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);

        Rect rect = new Rect(0,0,100,100);
        ActivityOptions activityOptions = ActivityOptions.makeBasic();
        ActivityOptions bounds = activityOptions.setLaunchBounds(rect);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.pay) {
            Toast.makeText(getApplicationContext(), getString(R.string.pay_premium), Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.broadcast) {
            Toast.makeText(getApplicationContext(), getString(R.string.ott), Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.user) {
            Toast.makeText(getApplicationContext(), getString(R.string.user_login), Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
