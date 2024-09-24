package com.nithin.twinleaves_assessment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "gtins")
@Data
public class Gtin {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gtin_id")
    private Long id;
    
    @Column(name = "gtin", nullable = false, length = 50, unique = true)
    private String gtin;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
}
