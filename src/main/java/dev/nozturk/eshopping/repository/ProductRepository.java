package dev.nozturk.eshopping.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.nozturk.eshopping.dto.ProductDTO;
import dev.nozturk.eshopping.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT new dev.nozturk.eshopping.dto.ProductDTO(p.id,  p.name, p.price, c.name) FROM Product p join p.category c  WHERE p.name LIKE %:name%")
	Page<ProductDTO> searchByName(@Param("name") String name, Pageable pageable);

	@Query("SELECT new dev.nozturk.eshopping.dto.ProductDTO(p.id,  p.name, p.price, c.name)  FROM Product p join p.category c  WHERE p.id = %:id%")
	Optional<ProductDTO> getProductById(Long id);

}
