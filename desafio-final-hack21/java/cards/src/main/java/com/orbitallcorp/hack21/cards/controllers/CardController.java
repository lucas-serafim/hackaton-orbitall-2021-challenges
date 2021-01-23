package com.orbitallcorp.hack21.cards.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}