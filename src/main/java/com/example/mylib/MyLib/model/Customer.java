package com.example.mylib.MyLib.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Id;

/**
 * Created by hp on 2017-08-10.
 */
public class Customer {

    @Getter
    @Id
    private String id;

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {}

    public String getFirstName(){ return lastName; }

}
