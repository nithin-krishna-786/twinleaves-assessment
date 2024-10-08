package com.nithin.twinleaves_assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nithin.twinleaves_assessment.dto.BatchDTO;
import com.nithin.twinleaves_assessment.dto.GtinDTO;
import com.nithin.twinleaves_assessment.dto.ProductDTO;
import com.nithin.twinleaves_assessment.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
		ProductDTO createdProductDTO = productService.createProduct(productDTO);
		return new ResponseEntity<>(createdProductDTO, HttpStatus.CREATED);
	}
	

}