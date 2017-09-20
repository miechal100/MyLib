package com.example.mylib.MyLib.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfiguration {

    @Autowired
    BookRepository bookRepository;
}
