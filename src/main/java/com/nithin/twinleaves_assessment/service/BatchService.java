package com.nithin.twinleaves_assessment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithin.twinleaves_assessment.dto.BatchDTO;
import com.nithin.twinleaves_assessment.dto.ProductDTO;
import com.nithin.twinleaves_assessment.entity.Batch;
import com.nithin.twinleaves_assessment.entity.Product;
import com.nithin.twinleaves_assessment.exceptions.ResourceNotFoundException;
import com.nithin.twinleaves_assessment.repo.BatchRepository;
import com.nithin.twinleaves_assessment.repo.ProductRepository;

@Service
public class BatchService {

	@Autowired
	private BatchRepository batchRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	public BatchDTO createBatch(BatchDTO batchDTO) {
		Batch batch = modelMapper.map(batchDTO, Batch.class);
		
		List<Product> productsInBatch = new ArrayList<Product>();
		
		List<ProductDTO> productDTOsInBatch = batchDTO.getProducts();

		for(ProductDTO p:productDTOsInBatch) {
			Long productId = p.getProductId();
			Optional<Product> product = productRepository.findById(productId);
			
			if(product.isPresent())
				productsInBatch.add(product.get());
			else
				throw new ResourceNotFoundException("Product Not found with given id");
		}
				
		batch.setProducts(productsInBatch);
		
		batch = batchRepository.save(batch);
		batchDTO = modelMapper.map(batch, BatchDTO.class);
		return batchDTO;
	}
}
