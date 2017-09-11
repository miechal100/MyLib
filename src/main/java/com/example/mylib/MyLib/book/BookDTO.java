package com.example.mylib.MyLib.book;

import lombok.Getter;

@Getter
public class BookDTO {

    private String id;
    private String title;
    private String author;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.author = book.getAuthor();
        this.title = book.getTitle();
    }
}
