package com.project.bootcamp.controller;


import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> saveStock(@Valid @RequestBody StockDTO dto){
		
		return ResponseEntity.ok(stockService.save(dto));
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> updateStock(@Valid @RequestBody StockDTO dto){
		
		return ResponseEntity.ok(stockService.update(dto));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDTO>> findAll(){
		return ResponseEntity.ok(stockService.findAll());
	}
	
	@GetMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok(stockService.findById(id));
		
	}
	
	@GetMapping(value = "/today" , produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<List<StockDTO>> findByToday(){
		return ResponseEntity.ok(stockService.findByToday());
	}
	
	@DeleteMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> deleteStock(@PathVariable Long id){
		return ResponseEntity.ok(stockService.deleteStock(id));
	}

}
