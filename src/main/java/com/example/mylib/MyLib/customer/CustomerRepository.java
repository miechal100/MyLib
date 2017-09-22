package com.example.mylib.MyLib.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by hp on 2017-08-24.
 */
@Repository
interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);
    Stream<Customer> findByLastName(String lastName);

}
