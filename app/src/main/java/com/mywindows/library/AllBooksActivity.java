package com.mywindows.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private static final String TAG = "AllBooksActivity";

    private RecyclerView booksRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d(TAG, "onCreate: started");

        booksRecView = findViewById(R.id.booksRecView);
        BookRecViewAdapter adapter = new BookRecViewAdapter(this);
        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager( new GridLayoutManager(this,3));


//        books.add( new Book("As a Man Thinketh Paperback",
//                " James Allen ",
//                1011,
//                "https://images-na.ssl-images-amazon.com/images/I/41YKHJHBV3L._SX321_BO1,204,203,200_.jpg",
//                "Can you think of a single moment in the whole day when your mind is blank and thoughtless?\n" +
//                        "Do you know how powerful every thought is?"));
//
//        books.add(new Book("The Great Gatsby",
//                "F. Scott Fitzgerald",
//                300,
//                "https://images-na.ssl-images-amazon.com/images/I/51IArD+InCL._SX320_BO1,204,203,200_.jpg",
//                "\n" +
//                        "It's the Roaring Twenties and New York City is the place to be. Everything can be purchased, everyone can be bought. But, can you make money erase your past?"));
//
//        books.add(new Book("To Kill A Mockingbird",
//                "Harper Lee",
//                500,
//                "https://images-na.ssl-images-amazon.com/images/I/51Z9p5AecCL._SX307_BO1,204,203,200_.jpg",
//                "A novel that explores the tragedy of racism in the 1930s and the dramatics of the 'Great Depression', Harper Lee’s 'To Kill A Mockingbird' is a tale that infuses humour and sorrow into a touching story that lives on eternally in the minds of the readers. Set in a town that has its roots in a history of prejudice, violence and hypocrisy, the story follows the lives of Scout and Jem Finch as they come of age and experience the discrimination that floods their society. They watch their father (a lawyer) struggle for the justice of a black man who is charged with the rape of a white girl. "));

        Util util = new Util();
        ArrayList<Book> books = new ArrayList<>();
        books = util.getAllBooks();
        adapter.setBooks(books);

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
//        overridePendingTransition(R.anim.closein, R.anim.);
    }
}