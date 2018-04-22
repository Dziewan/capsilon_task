package com.md.service;

import com.md.model.Customer;
import com.md.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface CustomerService {

    ResponseEntity<Customer> addCustomer(Customer customer);

    ResponseEntity<Customer> getCustomerById(long id);

    ResponseEntity<Customer> updateCustomer(long id, Customer customer);

    ResponseEntity<Collection<Customer>> getAllCustomers();

    String welcome();

    void deleteCustomerById(long id);

    void deleteAll();
}
