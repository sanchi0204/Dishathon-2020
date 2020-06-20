package com.example.watcho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class More extends AppCompatActivity {

 Button change_lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadLocale();
        setContentView(R.layout.activity_more);


        change_lang = findViewById(R.id.btn_change_lang);
        change_lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chooser();
            }
        });

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

    private void Chooser() {

        final String[] listItems = {getString(R.string.english), getString(R.string.hindi), getString(R.string.tamil), getString(R.string.kannada)};
        AlertDialog.Builder builder =new AlertDialog.Builder(More.this);
        builder.setTitle(getString(R.string.choose));
        builder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch(i)
                {
                    case 0:
                        setLocale("en");
                        recreate();
                        break;

                    case 1:
                        setLocale("hi");
                        recreate();
                        break;

                    case 2:
                        setLocale("ur");
                        recreate();
                        break;


                    case 3:
                        setLocale("pa");
                        recreate();
                        break;

                }
                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void setLocale(String lang) {

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Language", MODE_PRIVATE).edit();
        editor.putString("My_lang", lang);
        editor.apply();

    }

    public void LoadLocale()
    {
        SharedPreferences preferences = getSharedPreferences("Language", Activity.MODE_PRIVATE);
        String language = preferences.getString("My_lang", "");
        setLocale(language);
    }
}
