package com.example.mylib.MyLib;

import com.example.mylib.MyLib.book.Book;
import com.example.mylib.MyLib.customer.Customer;
import com.example.mylib.MyLib.book.BookRepository;
import com.example.mylib.MyLib.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
 		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		bookRepository.deleteAll();
		customerRepository.deleteAll();

		customerRepository.save(new Customer("Jan", "Kowalski"));
		customerRepository.save(new Customer("Piotr", "Jakiśtam"));
		bookRepository.save(new Book("Pan Tadeusz", "Adam Mickiewicz",
				customerRepository.findByFirstNameAndLastName("Jan", "Kowalski")));
		bookRepository.save(new Book("Dziady", "Adam Mickiewicz",
				customerRepository.findByFirstNameAndLastName("Piotr", "Jakiśtam")));

		System.out.println("Books found with findAll() method");
		System.out.println("^&*(&^&*&^&**&^&*&^^&*%*&$%^&*)))");
		for(Book book : bookRepository.findAll())
		System.out.println(book);

		System.out.println("Autor 'Dziadów'");
		System.out.println(bookRepository.findByTitle("Dziady"));

		System.out.println("Książki Adama Mickiewicza w bibliotece");
		for(Book book : bookRepository.findByAuthor("Adam Mickiewicz"))
		System.out.println(book);


	}
}
