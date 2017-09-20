package com.example.mylib.MyLib.renting;

import com.example.mylib.MyLib.book.BookConfiguration;
import com.example.mylib.MyLib.book.BookDTO;
import com.example.mylib.MyLib.book.BookService;
import com.example.mylib.MyLib.customer.CustomerConfiguration;
import com.example.mylib.MyLib.customer.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BookConfiguration.class, CustomerConfiguration.class})
@SpringBootTest
public class RentingServiceIntegrationTest {


    private BookService bookService;

    private CustomerService customerService;

    private BookRentService bookRentService;

    @Before
    public void setup(){

        bookRentService = new BookRentService(bookService, customerService);
        bookRentService.rent()
    }

    @Test
    public void test(){

    }
}
