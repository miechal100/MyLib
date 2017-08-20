package com.example.mylib.MyLib.model;

import com.example.mylib.MyLib.model.Book;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hp on 2017-08-10.
 */
@Repository
public interface BookRepository extends MongoRepository<Book, String>{

    public Book findByTitleAndAuthor(String title, String author);
    public List<Book> findByAuthor(String author);
    public Book findByTitle(String title);

}
