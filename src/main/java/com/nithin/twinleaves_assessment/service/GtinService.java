package com.nithin.twinleaves_assessment.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithin.twinleaves_assessment.dto.GtinDTO;
import com.nithin.twinleaves_assessment.entity.Gtin;
import com.nithin.twinleaves_assessment.repo.GtinRepository;

@Service
public class GtinService {
	
	@Autowired
	private GtinRepository gtinRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public GtinDTO createGtin(GtinDTO gtinDTO) {
		Gtin gtin = modelMapper.map(gtinDTO, Gtin.class);
		gtin = gtinRepository.save(gtin);
		gtinDTO = modelMapper.map(gtin, GtinDTO.class);
		return gtinDTO;
	}

}
