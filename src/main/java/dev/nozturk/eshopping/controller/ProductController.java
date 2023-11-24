package dev.nozturk.eshopping.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import dev.nozturk.eshopping.dto.ProductDTO;
import dev.nozturk.eshopping.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@GetMapping
	public ResponseEntity<PagedModel<EntityModel<ProductDTO>>> searchByName(@RequestParam String name,
			Pageable pageable) {
		Page<ProductDTO> products = productService.searchByName(name, pageable);
		PagedModel<EntityModel<ProductDTO>> pagedModel = (PagedModel<EntityModel<ProductDTO>>)PagedModel.of(
				products.map(product -> EntityModel.of(product,
						WebMvcLinkBuilder
								.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getById(product.getId()))
								.withSelfRel())),
				Link.of(WebMvcLinkBuilder.linkTo(ProductController.class).toUriComponentsBuilder().build()
						.toUriString()).withSelfRel());

		return ResponseEntity.ok(pagedModel);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(productService.getById(id));
	}

	private Link getSelfLink(Long id) {
		return Link.of(
				MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(ProductController.class).getById(id))
						.buildAndExpand().toUriString(),
				"self");
	}
}
