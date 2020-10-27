package com.mywindows.library;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button seeAllBtn, currentBtn, wantToBtn, alreadyBtn, aboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        initWidgets();
        setOnClickListners();
    }

    private void setOnClickListners () {
        seeAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });



        wantToBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WantToActivity.class);
                startActivity(intent);
            }
        });


        alreadyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadActivity.class);
                startActivity(intent);
            }
        });

        currentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingBookActivity.class);
                startActivity(intent);
            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutTapped();
            }
        });


    }
    private void aboutTapped () {
        Log.d(TAG, "aboutTapped: started");
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("About My Library App")
                .setMessage("BhelCOme TO my. Visit MY apps for More apps")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, MyWebViewActivity.class);
                        startActivity(intent);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        builder.create().show();


    }

    private void initWidgets () {
        seeAllBtn = findViewById(R.id.seeAllBtn);
        currentBtn = findViewById(R.id.currrentBtn);
        wantToBtn = findViewById(R.id.wantToBtn);
        alreadyBtn = findViewById(R.id.alreadyBtn);
        aboutBtn = findViewById(R.id.aboutBtn);

    }
}