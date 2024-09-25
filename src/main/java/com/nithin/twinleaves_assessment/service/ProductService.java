package com.nithin.twinleaves_assessment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.nithin.twinleaves_assessment.dto.BatchDTO;
import com.nithin.twinleaves_assessment.dto.GtinDTO;
import com.nithin.twinleaves_assessment.dto.ProductDTO;
import com.nithin.twinleaves_assessment.entity.Batch;
import com.nithin.twinleaves_assessment.entity.Gtin;
import com.nithin.twinleaves_assessment.entity.Product;
import com.nithin.twinleaves_assessment.repo.BatchRepository;
import com.nithin.twinleaves_assessment.repo.GtinRepository;
import com.nithin.twinleaves_assessment.repo.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private BatchRepository batchRepository;
    
    @Autowired
    private GtinRepository gtinRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    public ProductDTO createProduct(ProductDTO productDTO) {

    	Product product = modelMapper.map(productDTO, Product.class);
    	product = productRepository.save(product);
        
//        List<Batch> batches = productDTO.getBatches().stream()
//                .map(batchDTO -> modelMapper.map(batchDTO, Batch.class))
//                .collect(Collectors.toList());
//        batchRepository.saveAll(batches);
//        
//        List<Gtin> gtins = productDTO.getGtins().stream()
//                .map(gtinDTO -> modelMapper.map(gtinDTO, Gtin.class))
//                .collect(Collectors.toList());
//        gtinRepository.saveAll(gtins);
    	
    	productDTO = modelMapper.map(product, ProductDTO.class);
    	
        return productDTO;
    }
    
    public List<GtinDTO> getGtins(String gtin) {
        List<Gtin> gtins = gtinRepository.findByGtin(gtin);
        
        if(gtins == null)
        	throw new ResourceAccessException("Not a valid GTIN");
        
        List<GtinDTO> gtinDTOS = gtins.stream()
                .map(g -> modelMapper.map(g, GtinDTO.class))
                .collect(Collectors.toList());
        
        return gtinDTOS;
    }

    public List<BatchDTO> getBatchesWithPositiveQuantity() {
        List<Batch> batches = batchRepository.findByAvailableQuantityGreaterThan(0);
        List<BatchDTO> batchDTOS = batches.stream()
                .map(batch -> modelMapper.map(batch, BatchDTO.class))
                .collect(Collectors.toList());
        return batchDTOS;
    }

    public BatchDTO getLatestBatchWithNegativeOrZeroQuantity() {
        Batch batch = batchRepository.findTopByAvailableQuantityLessThanEqualOrderByInwardedOnDesc(0);
        BatchDTO batchDTO = modelMapper.map(batch, BatchDTO.class);
        return batchDTO;
    }
}
