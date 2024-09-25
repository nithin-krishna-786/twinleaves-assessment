package com.nithin.twinleaves_assessment.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BatchDTO {
    private Long id;
    
    @NotNull(message = "MRP cannot be null")
    private Integer mrp;
    
    @NotNull(message = "SP cannot be null")
    private Integer sp;
    
    @NotNull(message = "Purchase price cannot be null")
    private Integer purchasePrice;
    
    private Integer availableQuantity;
    
    @NotNull(message = "Inwarded on cannot be null")
    private LocalDate inwardedOn;
    
    private List<ProductDTO> products;
    
    public void setProducts(List<ProductDTO> products) {
        this.products = products;
        availableQuantity = products != null ? products.size() : 0;
    }
}




