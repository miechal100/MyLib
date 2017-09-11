package com.example.mylib.MyLib.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public BookDTO save(@RequestBody BookDTO bookDTO) {
        return bookService.save(bookDTO);
    }


}
