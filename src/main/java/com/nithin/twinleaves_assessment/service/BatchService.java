package com.nithin.twinleaves_assessment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithin.twinleaves_assessment.dto.BatchDTO;
import com.nithin.twinleaves_assessment.dto.BatchRequestDTO;
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

	public BatchDTO createBatch(BatchRequestDTO batchDTO) {
		Batch batch = modelMapper.map(batchDTO, Batch.class);
		List<Long> productIDsInBatch = batchDTO.getProductIds();
		
		List<Product> productsInBatch = new ArrayList<Product>();
		

		for(Long id:productIDsInBatch) {
//			Long productId = p.getId();
			Optional<Product> product = productRepository.findById(id);
			
			if(product.isPresent())
//				productsInBatch.add(product.get());
				batch.getProducts().add(product.get());
			else
				throw new ResourceNotFoundException("Product Not found with given id" + id);
		}
				
		
		batch = batchRepository.save(batch);
		BatchDTO result = modelMapper.map(batch, BatchDTO.class);
		return result;
	}
	
	public List<BatchDTO> getBatchesWithPositiveQuantity() {
		List<Batch> batches = batchRepository.findByAvailableQuantityGreaterThan(0);
		List<BatchDTO> batchDTOS = batches.stream().map(batch -> modelMapper.map(batch, BatchDTO.class))
				.collect(Collectors.toList());
		return batchDTOS;
	}

	public BatchDTO getLatestBatchWithNegativeOrZeroQuantity() {
		Optional<Batch> batch = batchRepository.findTopByAvailableQuantityLessThanEqualOrderByInwardedOnDesc(0);
		if(batch.isPresent())
			return modelMapper.map(batch.get(), BatchDTO.class);
		else
			throw new ResourceNotFoundException("No batch with given criteria");
	}

}

