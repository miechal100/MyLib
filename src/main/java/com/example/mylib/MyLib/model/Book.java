package com.example.mylib.MyLib.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by hp on 2017-08-10.
 */

@Getter
public class Book {

    @Id
    private String id;

    private String title;
    private String author;

    private Customer bookOwner;
    private Date date;

    public Book(){}

    public Book(String title, String author, Customer bookOwner){
        this.title = title;
        this.author = author;
        this.bookOwner = bookOwner;
        date = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
    }

    @Override
    public String toString() {
        return String.format("Book[id=%s, title=%s, author=%s, bookOwner=%s, date=%s]", id, title, author, bookOwner.getFirstName(), date);
    }
}
