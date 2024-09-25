package com.nithin.twinleaves_assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nithin.twinleaves_assessment.dto.BatchDTO;
import com.nithin.twinleaves_assessment.dto.GtinDTO;
import com.nithin.twinleaves_assessment.entity.Gtin;
import com.nithin.twinleaves_assessment.service.GtinService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/gtin")
public class GtinController {

	@Autowired
	private GtinService gtinService;
	
	@PostMapping
	public ResponseEntity<GtinDTO> createGtin(@RequestBody @Valid GtinDTO gtinDTO) {
	    GtinDTO createdGtinDTO = gtinService.createGtin(gtinDTO);
	    return ResponseEntity.ok(createdGtinDTO);
	}
	
	@GetMapping("/{gtin}")
	public ResponseEntity<GtinDTO> getGTIN(@PathVariable("gtin") String gtin)
	{
		 GtinDTO gtinDTO = gtinService.fetchGTIN(gtin);
		 return ResponseEntity.ok(gtinDTO);
	}
	
}
