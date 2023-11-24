package dev.nozturk.eshopping.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
	private Long id;
	private String name;
	private BigDecimal price;
	private String categoryName;

}
