package com.example.mylib.MyLib.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepositoryTest extends MongoRepository<Customer, String> {
}
