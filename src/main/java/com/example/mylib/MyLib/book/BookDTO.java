package com.example.mylib.MyLib.book;

import lombok.Getter;

@Getter
public class BookDTO {

    public BookDTO(Book book) {
        this.id = book.getId();
        this.author = book.getAuthor();
        this.title = book.getTitle();
    }

    private String id;
    private String title;
    private String author;
}
