package com.nithin.twinleaves_assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nithin.twinleaves_assessment.dto.BatchDTO;
import com.nithin.twinleaves_assessment.service.BatchService;

@RestController
@RequestMapping("/api/batch")
public class BatchController {
	
	@Autowired
	private BatchService batchService;
	
	@PostMapping
	public ResponseEntity<BatchDTO> createBatch(@RequestBody BatchDTO batchDTO) {
	    BatchDTO createdBatchDTO = batchService.createBatch(batchDTO);
	    return ResponseEntity.ok(createdBatchDTO);
	}

}
