package com.mywindows.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class CurrentlyReadingBookActivity extends AppCompatActivity {
    private static final String TAG = "CurrentlyReadingBookAct";

    private RecyclerView recyclerView;
    private Util utils;

    private BookRecViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading_book);

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        utils =  new Util();

        adapter = new BookRecViewAdapter(this);
        adapter.setType("currently reading");

        recyclerView = findViewById(R.id.recViewAlready);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        adapter.setBooks(utils.getCurrentlyReadingBooks());

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(R.anim.closein, R.anim.closeout);
    }


}
