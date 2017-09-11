package com.example.mylib.MyLib.customer;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hp on 2017-08-26.
 */
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    CustomerDTO findByFirstNameAndLastName(String firstName, String lastName){
        Customer customer = customerRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow( () -> new CustomerNotFoundException(firstName, lastName));

        return new CustomerDTO(customer);
    }

    List<CustomerDTO> findByLastName(String lastName){
        return customerRepository.findByLastName(lastName)
                .map(CustomerDTO::new)
                .collect(Collectors.toList());
    }

    CustomerDTO save(CustomerDTO customerDTO){
        Customer savedCustomer = customerRepository.save(new Customer(customerDTO.getFirstName(), customerDTO.getLastName()));
        return new CustomerDTO(savedCustomer);
    }

}
