package dev.nozturk.eshopping.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.nozturk.eshopping.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

  Optional<Address> findFirstByCustomer_Id(Long customerId);
  
  List<Address> findByCustomer_Id(Long customerId);

}
