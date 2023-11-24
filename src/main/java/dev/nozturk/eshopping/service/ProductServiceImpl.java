package dev.nozturk.eshopping.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.nozturk.eshopping.dto.ProductDTO;
import dev.nozturk.eshopping.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService {
	private final ProductRepository productRepository;

	@Transactional(readOnly = true )
	@Override
	public Page<ProductDTO> searchByName(String name, Pageable pageable) {
		return productRepository.searchByName(name, pageable);
	}

	@Transactional(readOnly = true )
	@Override
	public ProductDTO getById(Long id) {
		return productRepository.getProductById(id).orElseThrow(EntityNotFoundException::new);
	}

}
