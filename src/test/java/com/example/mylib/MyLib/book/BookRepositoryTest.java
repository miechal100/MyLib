package com.example.mylib.MyLib.book;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepositoryTest extends MongoRepository<Book, String> {
}
