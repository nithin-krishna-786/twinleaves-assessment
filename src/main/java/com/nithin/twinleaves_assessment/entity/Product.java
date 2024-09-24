package com.nithin.twinleaves_assessment.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "product_id")
	    private Long productId;
	    
	    @Column(name = "product_name", nullable = false, length = 100)
	    private String productName;
	    
	    @Column(name = "created_on", nullable = false)
	    private LocalDate createdOn;
	    
//	    @ManyToMany
//	    @JoinTable(
//	        name = "batch_products",
//	        joinColumns = @JoinColumn(name = "product_id"),
//	        inverseJoinColumns = @JoinColumn(name = "batch_id")
//	    )
//	    private List<Batch> batches = new ArrayList<>();
	    
	    @OneToMany(mappedBy = "product")
	    private List<Gtin> gtins = new ArrayList<>();
}