package com.example.mylib.MyLib.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hp on 2017-08-26.
 */
@Component
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public CustomerDTO findByFirstNameAndLastName(String firstName, String lastName){
        Customer customer = customerRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow( () -> new CustomerNotFoundException(firstName, lastName));

        return new CustomerDTO(customer);
    }

    public List<CustomerDTO> findByLastName(String lastName){
        return customerRepository.findByLastName(lastName)
                .map(CustomerDTO::new)
                .collect(Collectors.toList());
    }

    public CustomerDTO save(String firstName, String lastName){
        Customer savedCustomer = customerRepository.save(new Customer(firstName, lastName));
        return new CustomerDTO(savedCustomer);
    }

}
