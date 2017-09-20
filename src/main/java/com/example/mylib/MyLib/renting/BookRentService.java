package com.example.mylib.MyLib.renting;

import com.example.mylib.MyLib.book.BookDTO;
import com.example.mylib.MyLib.book.BookService;
import com.example.mylib.MyLib.customer.CustomerDTO;
import com.example.mylib.MyLib.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookRentService {

    private CustomerService customerService;
    private BookService bookService;

    @Autowired
    public BookRentService(BookService bookService, CustomerService customerService){
        this.bookService = bookService;
        this.customerService = customerService;
    }

    public BookRent rent(String title, String firstName, String lastName){

        CustomerDTO customer = customerService.

        validateBook();
        validateCustomer();

        return new BookRent(bookDTO, customerDTO);
    }

    public void validateBook(){

    }

    public void validateCustomer(){

    }
}
