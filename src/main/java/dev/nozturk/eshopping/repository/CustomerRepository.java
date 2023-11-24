package dev.nozturk.eshopping.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.nozturk.eshopping.dto.CustomerDTO;
import dev.nozturk.eshopping.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{ 
}
