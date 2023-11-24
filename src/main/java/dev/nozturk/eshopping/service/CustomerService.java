package dev.nozturk.eshopping.service;

import java.util.List;
import java.util.Optional;

import dev.nozturk.eshopping.model.Address;
import dev.nozturk.eshopping.model.Customer;

public interface CustomerService {
	Customer getById(Long id);
	List<Address> getAddresses(Long customerId);
	Optional<Address> findFirstAddressByCustomerId(Long customerId);

}
