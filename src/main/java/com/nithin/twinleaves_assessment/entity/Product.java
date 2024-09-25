package com.nithin.twinleaves_assessment.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "products")
@Data
public class Product {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "product_name", nullable = false, length = 100)
	    private String productName;
	    
	    @Column(name = "created_on", nullable = false)
	    @CreationTimestamp
	    private LocalDate createdOn;
	    
	    @ManyToMany
	    @JoinTable(
	        name = "batch_products",
	        joinColumns = @JoinColumn(name = "product_id"),
	        inverseJoinColumns = @JoinColumn(name = "batch_id")
	    )
	    private List<Batch> batches = new ArrayList<>();
	    
}