package com.example.mylib.MyLib.book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by hp on 2017-08-24.
 */
@Repository
interface BookRepository extends MongoRepository<Book, String> {

    Stream<Book> findByAuthor(String author);

    Optional<Book> findByTitle(String title);

}
