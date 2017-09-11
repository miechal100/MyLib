package com.example.mylib.MyLib.customer;

import com.example.mylib.MyLib.book.BookDTO;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by hp on 2017-08-10.
 */
@Getter
class Customer {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private List<BookDTO> booksOwned;

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
