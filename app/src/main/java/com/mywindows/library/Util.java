package com.mywindows.library;

import java.util.ArrayList;

public class Util {
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> alreadyReadBooks;

    private static int id = 0;


    public Util() {
        if (allBooks ==  null){
            allBooks = new ArrayList<>();
            initAllBooks();

        }

        if ( currentlyReadingBooks==  null){
            currentlyReadingBooks = new ArrayList<>();
        }

        if (wantToReadBooks ==  null){
            wantToReadBooks = new ArrayList<>();
        }

        if (alreadyReadBooks ==  null){
            alreadyReadBooks = new ArrayList<>();
        }
    }



    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public boolean addCurrentlyReadingBook (Book book){
         return currentlyReadingBooks.add(book);
    }

    public boolean addWantToReadBook (Book book){
        return wantToReadBooks.add(book);
    }

    public boolean addAlreadyReadBook (Book book){
        return alreadyReadBooks.add(book);
    }

    public boolean removeCurrentlyReadingBook (Book book){
        return currentlyReadingBooks.remove(book);
    }
    public boolean removeWantToReadBook (Book book){
        return wantToReadBooks.remove(book);
    }

    public boolean removeAlreadyReadBook (Book book){
        return alreadyReadBooks.remove(book);
    }

    private static void initAllBooks() {
        //TODO: Initialize all Books ArrayList.
        String name = "";
        String author = "";
        int pages = 0;
        String imageUrl ="";
        String description = "";


        id++;
        name = "As a Man Thinketh Paperback";
        author =" James Allen ";
        pages = 300;
        imageUrl ="https://images-na.ssl-images-amazon.com/images/I/41YKHJHBV3L._SX321_BO1,204,203,200_.jpg";
        description ="Can you think of a single moment in the whole day when your mind is blank and thoughtless?\n" +
                      "Do you know how powerful every thought is?";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "The Great Gatsby";
        author ="F. Scott Fitzgerald ";
        pages = 300;
        imageUrl ="https://images-na.ssl-images-amazon.com/images/I/51IArD+InCL._SX320_BO1,204,203,200_.jpg";
        description ="It's the Roaring Twenties and New York City is the place to be. Everything can be purchased, everyone can be bought. But, can you make money erase your past?";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "To Kill A Mockingbird";
        author ="Harper Lee";
        pages = 300;
        imageUrl ="https://images-na.ssl-images-amazon.com/images/I/51Z9p5AecCL._SX307_BO1,204,203,200_.jpg";
        description ="A novel that explores the tragedy of racism in the 1930s and the dramatics of the 'Great Depression'," +
                " Harper Lee’s 'To Kill A Mockingbird' is a tale that infuses humour and sorrow into a touching story that lives on eternally in the minds of the readers. " +
                "Set in a town that has its roots in a history of prejudice, violence and hypocrisy," +
                " the story follows the lives of Scout and Jem Finch as they come of age and experience the discrimination that floods their society.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "The Fixed Stars";
        author ="Molly Wizenberg";
        pages = 300;
        imageUrl ="https://images-na.ssl-images-amazon.com/images/I/41ZQ9UiondL._SX330_BO1,204,203,200_.jpg";
        description ="From a bestselling memoirist, a thoughtful and provocative story of changing identity, complex sexuality, and enduring family relationships";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "The Du Lac Prophecy ";
        author ="Mary Anne Yarde ";
        pages = 300;
        imageUrl ="https://m.media-amazon.com/images/I/41UfKhIWOEL._SY346_.jpg";
        description ="Two Prophesies. Two Noble Households. One Throne.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));






    }
}
