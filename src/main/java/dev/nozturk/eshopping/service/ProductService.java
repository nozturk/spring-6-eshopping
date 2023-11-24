package dev.nozturk.eshopping.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.nozturk.eshopping.dto.ProductDTO;

public interface ProductService {
	
	Page<ProductDTO> searchByName(String name, Pageable pageable);
	
	ProductDTO getById(Long id);

}
