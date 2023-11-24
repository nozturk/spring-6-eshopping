package dev.nozturk.eshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.nozturk.eshopping.model.Address;
import dev.nozturk.eshopping.model.Customer;
import dev.nozturk.eshopping.repository.AddressRepository;
import dev.nozturk.eshopping.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository customerRepository;

	private final AddressRepository addressRepository;

	@Override
	public Customer getById(Long id) {
		return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<Address> getAddresses(Long customerId) {
		return addressRepository.findByCustomer_Id(customerId);
	}

	@Override
	public Optional<Address> findFirstAddressByCustomerId(Long customerId) {
		return addressRepository.findFirstByCustomer_Id(customerId);
	}

}
