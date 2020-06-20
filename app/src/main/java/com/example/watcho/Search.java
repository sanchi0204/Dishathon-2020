package com.example.watcho;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Search extends AppCompatActivity {

ImageView sort;
Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        String[] countries = getResources().getStringArray(R.array.pop_shows);
        AutoCompleteTextView editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.custom_list_item, R.id.text_view_list_item, countries);
        editText.setAdapter(adapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.search);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.search: return true;
                    case R.id.downloads:
                        startActivity(new Intent(getApplicationContext(), Downloads.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.browse:
                        startActivity(new Intent(getApplicationContext(), Browse.class));
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

        sort = findViewById(R.id.mic);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChipDialog();
            }
        });
    }

    private void ChipDialog() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.chip_layout);
      //  Button dialogButton = dialog.findViewById(R.id.btn_rate);
        // if button is clicked, close the custom dialog
//        dialogButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
        dialog.show();

    }


}
