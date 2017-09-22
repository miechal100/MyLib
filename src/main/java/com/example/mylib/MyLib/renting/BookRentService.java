package com.example.mylib.MyLib.renting;

import com.example.mylib.MyLib.book.BookDTO;
import com.example.mylib.MyLib.book.BookNotFoundException;
import com.example.mylib.MyLib.book.BookService;
import com.example.mylib.MyLib.customer.CustomerDTO;
import com.example.mylib.MyLib.customer.CustomerNotFoundException;
import com.example.mylib.MyLib.customer.CustomerService;

public class BookRentService {

    private CustomerService customerService;
    private BookService bookService;

    public BookRentService(BookService bookService, CustomerService customerService){
        this.bookService = bookService;
        this.customerService = customerService;
    }

    public BookRent rentBook(BookDTO bookDTO, CustomerDTO customerDTO){

        BookDTO book = bookService.findByTitle(bookDTO.getTitle());
        CustomerDTO customer = customerService.findByFirstNameAndLastName(customerDTO.getFirstName(),
                customerDTO.getLastName());

        validateBook(book);
        validateCustomer(customer);

        if(bookDTO.isRented()) return null;

        bookDTO.changeBookStatus();

        return new BookRent(bookDTO, customerDTO);
    }

    public BookRent returnBook(BookRent bookRent){

        if(bookRent != null){
            bookRent.getBookDTO().changeBookStatus();
            return null;
        }
        throw new BookNotRentedException();
    }

    public void validateBook(BookDTO book){
        if(book == null)
        throw new BookNotFoundException();
    }

    public void validateCustomer(CustomerDTO customer){
        if(customer == null)
        throw new CustomerNotFoundException(customer.getFirstName(), customer.getLastName());
    }
}





