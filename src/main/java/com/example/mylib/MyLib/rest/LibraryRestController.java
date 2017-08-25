package com.example.mylib.MyLib.rest;

import com.example.mylib.MyLib.book.Book;
import com.example.mylib.MyLib.book.BookRepository;
import com.example.mylib.MyLib.customer.CustomerRepository;
import com.example.mylib.MyLib.customer.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017-08-10.
 */


@RequestMapping("/library")
@RestController
public class LibraryRestController {

    private CustomerRepository customerRepository;
    private BookRepository bookRepository;

    @Autowired
    public LibraryRestController(CustomerRepository customerRepository, BookRepository bookRepository){
        this.customerRepository = customerRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{customerFirstName}/{customerLastName}")
    public Book getBooksRentedByCustomer(@PathVariable String customerFirstName, @PathVariable String customerLastName){
        validateCustomer(customerFirstName, customerLastName);

        return bookRepository.findByBookOwner(customerRepository.findByFirstNameAndLastName(customerFirstName, customerLastName));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/author/{authorFirstName}/{authorLastName}")
    public ArrayList<Book> getBooksFromAuthor(@PathVariable String authorFirstName, @PathVariable String authorLastName){
        validateAuthor(authorFirstName + " " + authorLastName);

        return bookRepository.findByAuthor(authorFirstName + " " + authorLastName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public List<Book> getBooksFromLibrary(){

        return bookRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add/{title}/{authorFirstName}/{authorLastName}" )
    public ResponseEntity<?> addBookToLibrary(@PathVariable String title, @PathVariable String authorFirstName,
                                              @PathVariable String authorLastName){

        HttpHeaders httpHeader = new HttpHeaders();

        Book newBook = this.bookRepository.save(new Book(title, authorFirstName+" "+authorLastName, null));

        return new ResponseEntity<>(HttpStatus.OK);
    }


    private void validateCustomer(String customerFirstName, String customerLastName) {

        if(customerRepository.findByFirstNameAndLastName(customerFirstName, customerLastName) == null)
            throw new CustomerNotFoundException(customerFirstName, customerLastName);

    }

    private void validateAuthor(String author) {

        if(bookRepository.findByAuthor(author) == null)
            throw new AuthorNotFoundException(author);

    }

}
