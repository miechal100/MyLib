package com.example.mylib.MyLib.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by hp on 2017-08-16.
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{

    ArrayList<Customer> findByFirstName(String firstName);
    Customer findByFirstNameAndLastName(String firstName ,String lastName);

}
