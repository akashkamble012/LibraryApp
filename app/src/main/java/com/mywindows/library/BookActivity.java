package com.mywindows.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private static final String TAG = "BookActivity";

    private TextView bookName, authorName, bookDescription, pageNumbers;
    private ImageView bookImage;
    private Button btnCurReading, btnWantToRead, btnAlreadyRead;

    private Book incomingBook;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        Intent intent = getIntent();
        int id = intent.getIntExtra("bookId", 0);
         util = new Util();
        ArrayList<Book> books = util.getAllBooks();

        for (Book b: books) {
            if (b.getId() == id){

                incomingBook = b;
                bookName.setText(b.getName());
                authorName.setText(b.getAuthor());
                bookDescription.setText(b.getDescription());
                pageNumbers.setText("Pages:" + b.getPages());
                Glide.with(this)
                        .asBitmap()
                        .load(b.getImageUrl())
                        .into(bookImage);
            }
        }

        btnCurReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCurReadingTapped();
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAlreadyReadTapped();
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnWantToReadTapped();
            }
        });

    }
    private void btnWantToReadTapped () {
        Log.d(TAG, "btnWantToReadTapped: Started");
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);



        ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();

        if (wantToReadBooks.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You have already added this book to Want To Books");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }
        else
        {
            ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
            if (alreadyReadBooks.contains(incomingBook)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setMessage("You  are already reading This Book");

                builder.setTitle("Error");

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();
            }
            else {

                ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();
                if (currentlyReadingBooks.contains(incomingBook)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);

                    builder.setMessage("You are Currently Reading  This Book");

                    builder.setTitle("Error");

                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.setCancelable(false);
                    builder.create().show();


                }else {
                    util.addWantToReadBook(incomingBook);
                    Toast.makeText(this, "The Book" + incomingBook.getName() +"has been succesfully added to Want TO Read Books", Toast.LENGTH_SHORT).show();

                }
            }

        }
    }

    private void btnCurReadingTapped () {
        Log.d(TAG, "btnCurReadingTapped: Started");



        ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();

        if (currentlyReadingBooks.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You have already added this book to Currently Reading Books");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }
        else
        {

            ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();
            if (wantToReadBooks.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Area You Going to start reading this book?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    util.removeWantToReadBook(incomingBook);
                    util.addCurrentlyReadingBook(incomingBook);
                        Toast.makeText(BookActivity.this, "The Book" + incomingBook.getName() +"has been succesfully added to Currently reading Books", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();
            }else{

                ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();

                if (alreadyReadBooks.contains(incomingBook)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Do you want to read this Book again?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            util.addCurrentlyReadingBook(incomingBook);
                            Toast.makeText(BookActivity.this, "The Book" + incomingBook.getName() +"has been succesfully added to Currently reading Books", Toast.LENGTH_SHORT).show();

                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.setCancelable(false);
                    builder.create().show();


                }else{
                    util.addCurrentlyReadingBook(incomingBook);
                    Toast.makeText(this, "The Book" + incomingBook.getName() +"has been succesfully added to Currently reading Books", Toast.LENGTH_SHORT).show();


                }
            }

        }

    }

    private void btnAlreadyReadTapped () {
        Log.d(TAG, "btnAlreadyReadTapped: Started");



        ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();

        if (alreadyReadBooks.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You have already added this book to Already Read Books");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }
        else
        {
            ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();
            if (currentlyReadingBooks.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Have You Finished Reading This book");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        util.removeCurrentlyReadingBook(incomingBook);
                        util.addAlreadyReadBook(incomingBook);
                        Toast.makeText(BookActivity.this, "The Book" + incomingBook.getName() +"has been succesfully added to Currently reading Books", Toast.LENGTH_SHORT).show();


                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();


            } else{
                util.addAlreadyReadBook(incomingBook);
                Toast.makeText(this, "The Book" + incomingBook.getName() +"has been succesfully added to Currently reading Books", Toast.LENGTH_SHORT).show();

            }

        }
    }



    private void initWidgets () {
        bookName = findViewById(R.id.bookName);
        authorName = findViewById(R.id.authorName);
        bookDescription = findViewById(R.id.bookDescription);
        pageNumbers = findViewById(R.id.bookPages);

        bookImage = findViewById(R.id.bookImage);

        btnCurReading = findViewById(R.id.btnCurReading);
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);

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