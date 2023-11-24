package dev.nozturk.eshopping.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nozturk.eshopping.model.Address;
import dev.nozturk.eshopping.service.AddressService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/adresses")
@RequiredArgsConstructor
public class AdressController {
	private final AddressService addressService;
	@GetMapping
	public ResponseEntity<Address> getById(@PathVariable Long id){
		return ResponseEntity.ok(addressService.getById(id));
	}
}
