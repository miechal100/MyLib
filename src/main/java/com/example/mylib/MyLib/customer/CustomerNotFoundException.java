package com.example.mylib.MyLib.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hp on 2017-08-23.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String customerFirstName, String customerLastName){
        super(customerFirstName + " " + customerLastName + " not found");
    }

}
