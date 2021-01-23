package com.orbitallcorp.hack21.cards.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.domains.dto.CardDTO;
import com.orbitallcorp.hack21.cards.service.CardService;

@RestController
@RequestMapping(value = "/cards")
public class CardController {

	@Autowired
	private CardService cardService;
	
	@GetMapping
	public ResponseEntity<List<CardDTO>> findAll(){
		List<CardDTO> cards = cardService.findAll();
		return ResponseEntity.status(200).body(cards);
	}
	
	@PostMapping
	public ResponseEntity<CardDTO> insert(@RequestBody CardDTO dto){
		dto = cardService.insert(dto);
		return ResponseEntity.status(201).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CardDTO> update(@PathVariable Long id, @RequestBody CardDTO dto){
		dto = cardService.update(id, dto);
		return ResponseEntity.status(200).body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		try {
			cardService.delete(id);
			return ResponseEntity.status(200).build();
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(404).build();
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CardDTO> findById(@PathVariable Long id){
		try {
			CardDTO dto = cardService.findById(id);
			return ResponseEntity.status(200).body(dto);
		} catch(NoSuchElementException e) {
			return ResponseEntity.status(404).build();
		}
	}
	
	@GetMapping(value = "/paginationAndSorting")
	public ResponseEntity<List<Card>> findAllPagination(
			@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize){
		
		List<Card> list = cardService.findAllPagination(pageNo, pageSize);
	
		return ResponseEntity.status(200).body(list);
	}
}