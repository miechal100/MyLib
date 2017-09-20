package com.example.mylib.MyLib.renting;

import com.example.mylib.MyLib.book.BookDTO;
import com.example.mylib.MyLib.customer.CustomerDTO;

import java.util.Date;

public class BookRent {

    private String bookId;
    private String title;
    private String customerId;

    private Date rentDate;

    public BookRent(BookDTO book, CustomerDTO customer){
        this.bookId = book.getId();
        this.title = book.getTitle();
        this.customerId = customer.getCustomerId();
    }


}
