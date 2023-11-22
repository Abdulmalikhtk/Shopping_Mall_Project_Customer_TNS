package tns.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tns.customer.entity.Customer;
import tns.customer.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer cust) {
        return customerRepository.save(cust);
    }

    public Optional<Customer> getCustomer(long id) {
        return customerRepository.findById(id);
    }

    public Customer update(long id, Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        
        if (optionalCustomer.isPresent()) {
            Customer cust = optionalCustomer.get();
            cust.setName(updatedCustomer.getName());
            // You can update other fields as needed
            return customerRepository.save(cust);
        } else {
            // Handle the case when the customer with the given ID is not found
            throw new RuntimeException("Customer with ID " + id + " not found");
        }
    }

    public String delete(long id) {
        customerRepository.deleteById(id);
        return "Entity with this id is deleted: " + id;
    }

    public List<Customer> getCustList() {
        return customerRepository.findAll();
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
