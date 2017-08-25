package com.example.mylib.MyLib.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    List<BookDTO> findByAuthor(String author) {
        return bookRepository.findByAuthor(author)
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    BookDTO findByTitle(String title) {
        Book book = bookRepository.findByTitle(title).orElseThrow(BookNotFoundException::new);
        return new BookDTO(book);
    }

    BookDTO save(BookDTO bookDTO) {
        Book savedBook = bookRepository.save(new Book(bookDTO.getTitle(), bookDTO.getAuthor()));
        return new BookDTO(savedBook);
    }
}
