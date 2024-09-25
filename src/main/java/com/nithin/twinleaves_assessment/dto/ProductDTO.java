package com.nithin.twinleaves_assessment.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {
	
	private Long id;

	@NotNull(message = "Product name cannot be null")
	@Size(min = 1, max = 100, message = "Product name must be between 1 and 100 characters")
	private String productName;

	private LocalDate createdOn;

	private List<BatchDTO> batches;

}
