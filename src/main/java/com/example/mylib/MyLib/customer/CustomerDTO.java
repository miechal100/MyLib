package com.example.mylib.MyLib.customer;

import lombok.Getter;

/**
 * Created by hp on 2017-08-26.
 */
@Getter
public class CustomerDTO{

    private String firstName;
    private String lastName;

    public CustomerDTO(Customer customer){
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
    }

}
