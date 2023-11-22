package tns.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tns.customer.entity.Customer;
import tns.customer.service.CustomerService;

@RestController
@RequestMapping("/customer") // Set the base path for the controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // http://localhost:8071/customer - POST
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    // http://localhost:8071/customer/2 - GET
    @GetMapping(path = "/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return customerService.getCustomer(id).orElse(null);
    }

    // http://localhost:8071/customer/2 - PUT
    @PutMapping(path = "/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
        return customerService.update(id, customer);
    }

    // http://localhost:8071/customer/2 - DELETE
    @DeleteMapping(path = "/{id}")
    public String deleteCustomer(@PathVariable long id) {
        return customerService.delete(id);
    }

    // http://localhost:8071/customer - GET
    @GetMapping
    public List<Customer> getAllCustomer() {
        return customerService.getCustList();
    }

    public CustomerService getCustomerService() {
        return customerService;
    }
}
