package com.example.mylib.MyLib.book;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * Created by hp on 2017-08-10.
 */

@ToString
@Getter
class Book {

    @Id
    private String id;

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
