package com.example.mylib.MyLib.book;

import lombok.Getter;

@Getter
public class BookDTO {

    private String id;
    private String title;
    private String author;

    private boolean rented;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.author = book.getAuthor();
        this.title = book.getTitle();
        rented = false;
    }

    public void changeBookStatus(){
        if(rented)
            rented = false;
        else
            rented = true;
    }

    public boolean isRented(){
        return rented;
    }
}
