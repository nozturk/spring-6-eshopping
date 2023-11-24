package dev.nozturk.eshopping.controller;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import dev.nozturk.eshopping.model.Address;
import dev.nozturk.eshopping.model.Customer;
import dev.nozturk.eshopping.service.CustomerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService customerService;

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Customer>> getById(@PathVariable Long id) {
		final Customer customer = customerService.getById(id);

		return ResponseEntity.ok(addLinks(customer));
	}

	@GetMapping("/{customerId}/adresses")
	public ResponseEntity<List<Address>> getAdresses(@PathVariable Long customerId) {

		return ResponseEntity.ok(customerService.getAddresses(customerId));
	}

	private EntityModel<Customer> addLinks(Customer customer) {
		EntityModel<Customer> resource = EntityModel.of(customer);

		if (customerService.findFirstAddressByCustomerId(customer.getId()).isPresent()) {
			Link adressLink = Link.of(MvcUriComponentsBuilder
					.fromMethodCall(MvcUriComponentsBuilder.on(CustomerController.class).getById(customer.getId()))
					.buildAndExpand().toUriString(), "self");
			resource.add(adressLink);

			Link customerAddressesLink = Link.of(MvcUriComponentsBuilder
					.fromMethodCall(MvcUriComponentsBuilder.on(CustomerController.class).getAdresses(customer.getId()))
					.buildAndExpand().toUriString(), "getAdresses");
			resource.add(customerAddressesLink);

		}

		return resource;
	}

}
