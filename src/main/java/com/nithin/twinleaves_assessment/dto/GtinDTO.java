package com.nithin.twinleaves_assessment.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GtinDTO {
	
    private Long id;
    
    @NotNull(message = "GTIN cannot be null")
    @Size(min = 1, max = 50, message = "GTIN must be between 1 and 50 characters")
    private String gtin;
    
    @NotNull(message = "Product cannot be null")
    private ProductDTO product;
}
