package com.example.mylib.MyLib.renting;

import com.example.mylib.MyLib.book.BookDTO;
import com.example.mylib.MyLib.customer.CustomerDTO;
import com.example.mylib.MyLib.utils.DateUtils;
import lombok.Getter;

import java.util.Date;

@Getter
public class BookRent {

    private BookDTO bookDTO;
    private CustomerDTO customerDTO;

    private Date rentDate;

    public BookRent(BookDTO book, CustomerDTO customer){
        this.bookDTO = book;
        this.customerDTO = customer;
        rentDate = DateUtils.now();
    }


}
