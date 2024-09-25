package com.nithin.twinleaves_assessment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nithin.twinleaves_assessment.dto.BatchDTO;
import com.nithin.twinleaves_assessment.dto.BatchRequestDTO;
import com.nithin.twinleaves_assessment.service.BatchService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/batch")
public class BatchController {

	@Autowired
	private BatchService batchService;

	@PostMapping
	public ResponseEntity<BatchDTO> createBatch(@RequestBody @Valid BatchRequestDTO batchDTO) {
		BatchDTO createdBatchDTO = batchService.createBatch(batchDTO);
		return ResponseEntity.ok(createdBatchDTO);
	}

	@GetMapping("/available")
	public ResponseEntity<List<BatchDTO>> getBatchesWithPositiveQuantity() {
		List<BatchDTO> batchDTOS = batchService.getBatchesWithPositiveQuantity();
		return new ResponseEntity<>(batchDTOS, HttpStatus.OK);
	}

	@GetMapping("/latest")
	public ResponseEntity<BatchDTO> getLatestBatchWithNegativeOrZeroQuantity() {
		BatchDTO batchDTO = batchService.getLatestBatchWithNegativeOrZeroQuantity();
		return new ResponseEntity<>(batchDTO, HttpStatus.OK);
	}

}
