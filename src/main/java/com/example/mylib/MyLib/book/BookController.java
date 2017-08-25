package com.example.mylib.MyLib.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/book")
@RestController
class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/author/{author}")
    public List<BookDTO> getBooksByAuthor(@PathVariable("author") String author) {
        return bookService.findByAuthor(author);
    }

    @GetMapping("/title/{title}")
    public BookDTO getBookByTitle(@PathVariable("title") String title) {
        return bookService.findByTitle(title);
    }


}
