package com.example.mylib.MyLib.customer;


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

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    private Optional<Customer> getCustomerOptional(Customer customer){
        return Optional.of(customer);
    }

    private Stream<Customer> getCustomerStream(List<Customer> customerList){
        return customerList.stream();
    }

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        Optional<Customer> customerOptional= getCustomerOptional(new Customer("Jan", "Kowalski"));
        Mockito.when(customerRepository.findByFirstNameAndLastName("Jan", "Kowalski"))
                .thenReturn(customerOptional);

        Mockito.when(customerRepository.findByLastName("Kowalski"))
                .thenReturn(getCustomerStream(makeList()));

        Mockito.when(customerRepository.findByFirstNameAndLastName("Jan", "Konieczny"))
                .thenReturn(Optional.empty());

        Mockito.when(customerRepository.findByLastName("Konieczny"))
                .thenReturn(Stream.empty());

        customerService = new CustomerService(customerRepository);
    }

    @Test
    public void customerFound() throws Exception{
        Assert.assertNotNull(customerService.findByFirstNameAndLastName("Jan", "Kowalski"));
     }

    @Test
    public void customerNotFound() throws Exception{
        Assertions.assertThatThrownBy(() -> customerService.findByFirstNameAndLastName("Jan","Konieczny"))
                .hasMessage("Jan Konieczny not found");
    }

    @Test
    public void customersFound() throws Exception{
        Assert.assertNotNull(customerService.findByLastName("Kowalski"));
    }

    @Test
    public void customersNotFound() throws Exception {
        Assertions.assertThat(customerService.findByLastName("Konieczny")).isEmpty();
    }

    private List<Customer> makeList() {
        Customer customer1 = new Customer("Jan", "Kowalski");
        Customer customer2 = new Customer("Aadam", "Kowalski");
        Customer customer3 = new Customer("Jacek", "Jackowski");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        return customerList;
    }
}
