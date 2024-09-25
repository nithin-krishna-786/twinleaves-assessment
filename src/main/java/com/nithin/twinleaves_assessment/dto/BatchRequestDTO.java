package com.nithin.twinleaves_assessment.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BatchRequestDTO {
	
		@Positive(message = "MRP cannot be negative")
	    private Integer mrp;
	    
		@Positive(message = "SP cannot be negative")
	    private Integer sp;
	    
		@Positive(message = "Purchase price cannot be negative")
	    private Integer purchasePrice;
	    
	    private Integer availableQuantity;
	    
	    @NotNull(message = "Inwarded on cannot be null")
	    private LocalDate inwardedOn;
	    
	    private List<Long> productIds;	    
}
