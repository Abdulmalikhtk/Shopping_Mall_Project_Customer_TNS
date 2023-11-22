package tns.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tns.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
