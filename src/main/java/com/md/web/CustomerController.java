package com.md.web;

import com.md.model.Customer;
import com.md.model.User;
import com.md.service.CustomerRepository;
import com.md.service.CustomerService;
import com.md.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CustomerController implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome() {
        return "Service works properly";
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

        Customer currentCustomer = new Customer.Builder()
                .name(customer.getName())
                .surname(customer.getSurname())
                .pesel(customer.getPesel())
                .build();

        return new ResponseEntity<>(customerRepository.save(currentCustomer), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Customer>> getAllCustomers() {

        Collection<Customer> response = customerRepository.findAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {

        Customer response = customerRepository.findOne(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "customer/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {

        Customer currentCustomer = customerRepository.findOne(id);

        currentCustomer.setName(customer.getName());
        currentCustomer.setSurname(customer.getSurname());
        currentCustomer.setPesel(customer.getPesel());

        Customer response = customerRepository.save(currentCustomer);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "customer/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCustomerById(@PathVariable long id) {
        customerRepository.delete(id);
    }

    @Override
    @RequestMapping(value = "customer/deleteAll", method = RequestMethod.DELETE)
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
