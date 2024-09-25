package com.nithin.twinleaves_assessment.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "batches")
@Data
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "batch_id")
	private Long batchId;

	@Column(name = "mrp", nullable = false)
	private Integer mrp;

	@Column(name = "sp", nullable = false)
	private Integer sp;

	@Column(name = "purchase_price", nullable = false)
	private Integer purchasePrice;

	@Column(name = "available_quantity")
	private Integer availableQuantity;

	@Column(name = "inwarded_on", nullable = false)
	private LocalDate inwardedOn;

	@ManyToMany
	@JoinTable(name = "batch_products",
	 joinColumns = @JoinColumn(name = "batch_id"),
	 inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products = new ArrayList<>();
	
	public void setProducts(List<Product> products) {
	    this.products = products;
	    availableQuantity = products != null ? products.size() : 0;
	}

}