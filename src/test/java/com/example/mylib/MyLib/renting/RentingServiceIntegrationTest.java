package com.example.mylib.MyLib.renting;

import com.example.mylib.MyLib.book.BookDTO;
import com.example.mylib.MyLib.book.BookService;
import com.example.mylib.MyLib.customer.CustomerDTO;
import com.example.mylib.MyLib.customer.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentingServiceIntegrationTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    private BookRentService bookRentService;

    private BookDTO bookDTO;
    private CustomerDTO customerDTO;

    @Before
    public void setup(){
        bookDTO = bookService.save("Pan Tadeusz", "Adam Mickiewicz");
        customerDTO = customerService.save("Michał", "N");

        bookRentService = new BookRentService(bookService, customerService);
    }

    @Test
    public void rentingSuccesful() throws Exception{

        bookRentService.rentBook(bookDTO, customerDTO);
        Assert.assertTrue(bookDTO.isRented());

    }

    @Test
    public void rentingFailed() throws Exception{

        BookRent bookRent = bookRentService.rentBook(bookDTO, customerDTO);
        Assert.assertNotNull(bookRent);

        bookRent = bookRentService.rentBook(bookDTO, customerDTO);
        Assert.assertNull(bookRent);
    }

    @Test
    public void returningSuccessful() throws Exception {

        BookRent bookRent = bookRentService.rentBook(bookDTO, customerDTO);
        Assert.assertNotNull(bookRent);

        bookRent = bookRentService.returnBook(bookRent);
        Assert.assertNull(bookRent);
        Assert.assertFalse(bookDTO.isRented());

    }

    @Test
    public void returningFailed() throws Exception {

        BookRent bookRent = bookRentService.rentBook(bookDTO, customerDTO);
        bookRent = bookRentService.returnBook(bookRent);
        Assert.assertNull(bookRent);

        BookRent bookRentJustReturned = bookRent;
        Assertions.assertThatThrownBy(() -> bookRentService.returnBook(bookRentJustReturned))
                .isInstanceOf(BookNotRentedException.class);

    }
}
