package com.example.mylib.MyLib.book;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    private Optional<Book> getBookOptional(Book book) {
        return Optional.of(book);
    }

    private Stream<Book> getBookStream(List<Book> bookList) {
        return bookList.stream();
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(bookRepository.findByTitle("Pan Tadeusz"))
                .thenReturn(getBookOptional(new Book("Pan Tadeusz", "Adam Mickiewicz")));

        Mockito.when(bookRepository.findByAuthor("Adam Mickiewicz"))
                .thenReturn(getBookStream(makeList()));

        Mockito.when(bookRepository.findByTitle("Panda Teusz"))
                .thenReturn(Optional.empty());

        Mockito.when(bookRepository.findByAuthor("Jan Kochanowski"))
                .thenReturn(Stream.empty());

        bookService = new BookService(bookRepository);
    }

    @Test
    public void bookFound() {
        Assert.assertNotNull(bookService.findByTitle("Pan Tadeusz"));
    }

    @Test
    public void bookNotFound() {
        Assertions.assertThatThrownBy(() -> bookService.findByTitle("Panda Teusz"))
                .isInstanceOf(BookNotFoundException.class);
    }

    @Test
    public void authorBooksFound() {
        Assert.assertNotNull(bookService.findByAuthor("Adam Mickiewicz"));
    }

    @Test
    public void authorBooksNotFound() {
        Assertions.assertThat(bookService.findByAuthor("Jan Kochanowski")).isEmpty();
    }

    private List<Book> makeList() {
        Book book1 = new Book("Dziady", "Adam Mickiewicz");
        Book book2 = new Book("Pan Tadeusz", "Adam Mickiewicz");
        Book book3 = new Book("Lalka", "Bolesław Prus");
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        return bookList;
    }
}
