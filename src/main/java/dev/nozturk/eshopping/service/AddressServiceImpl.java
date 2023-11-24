package dev.nozturk.eshopping.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.nozturk.eshopping.model.Address;
import dev.nozturk.eshopping.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
	private final AddressRepository addressRepository;
	@Override
	@Transactional(readOnly = true)
	public Address getById(Long id) {
		return addressRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

}
