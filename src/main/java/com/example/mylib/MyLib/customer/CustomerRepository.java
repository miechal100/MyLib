package com.example.mylib.MyLib.customer;

import com.example.mylib.MyLib.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by hp on 2017-08-24.
 */
@Repository
interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstNameAndLastName(String firstName, String lastName);
    ArrayList<Customer> findByFirstName(String firstName);

}
