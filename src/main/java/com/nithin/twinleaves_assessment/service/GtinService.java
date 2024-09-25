package com.nithin.twinleaves_assessment.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithin.twinleaves_assessment.dto.GtinDTO;
import com.nithin.twinleaves_assessment.dto.ProductDTO;
import com.nithin.twinleaves_assessment.entity.Gtin;
import com.nithin.twinleaves_assessment.entity.Product;
import com.nithin.twinleaves_assessment.exceptions.ResourceNotFoundException;
import com.nithin.twinleaves_assessment.repo.GtinRepository;
import com.nithin.twinleaves_assessment.repo.ProductRepository;

@Service
public class GtinService {

	@Autowired
	private GtinRepository gtinRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	public GtinDTO createGtin(GtinDTO gtinDTO) {
		
		Gtin gtin = new Gtin();
		gtin.setGtin(gtinDTO.getGtin());
		
		Long productId = gtinDTO.getProduct().getId();
		Optional<Product> product = productRepository.findById(productId);

		if (product.isPresent()) {
			gtin.setProduct(product.get());
		} else
			throw new ResourceNotFoundException("Product not found with id:" + productId);

		gtin = gtinRepository.save(gtin);
		
		gtinDTO.setId(gtin.getId());
		Product prod = gtin.getProduct();
		
		ProductDTO prodDTO = new ProductDTO();
		prodDTO.setProductName(prod.getProductName());
		prodDTO.setCreatedOn(prod.getCreatedOn());
		prodDTO.setId(prod.getId());
		
		gtinDTO.setProduct(prodDTO);
		
		return gtinDTO;
	}

	public GtinDTO fetchGTIN(String gtin) {
		Optional<Gtin> result = gtinRepository.findByGtin(gtin);
		
		if(result.isPresent())
		{
			Gtin res = result.get();
			GtinDTO gtinDTO = new GtinDTO();
			gtinDTO.setId(res.getId());
			gtinDTO.setGtin(res.getGtin());
			return gtinDTO;
		}
		else
			throw new ResourceNotFoundException("No gtin found");
	}

}
