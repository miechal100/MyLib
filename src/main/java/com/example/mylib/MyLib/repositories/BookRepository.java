package com.example.mylib.MyLib.repositories;

import com.example.mylib.MyLib.model.Book;
import com.example.mylib.MyLib.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by hp on 2017-08-24.
 */
@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    Book findByTitleAndAuthor(String title, String author);
    ArrayList<Book> findByAuthor(String author);
    Book findByBookOwner(Customer bookOwner);
    Book findByTitle(String title);

}
