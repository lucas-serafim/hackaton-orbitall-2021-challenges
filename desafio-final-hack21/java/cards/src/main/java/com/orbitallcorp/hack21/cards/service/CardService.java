package com.orbitallcorp.hack21.cards.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.domains.dto.CardDTO;
import com.orbitallcorp.hack21.cards.repositories.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;
	
	@Transactional(readOnly = true)
	public List<CardDTO> findAll(){
		List<Card> cards = (List<Card>) cardRepository.findAll();
		return cards.stream().map(x -> new CardDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public CardDTO insert(CardDTO dto) {
		Card card = new Card(null, dto.getCardNumber(), dto.getEmbossName(), dto.getCustomerName(), dto.getDocumentNumber(), dto.getMotherName(), dto.getAddress(), dto.getCity());
		card = cardRepository.save(card);
		return new CardDTO(card);
	}
	
	@Transactional
	public CardDTO update(Long id, CardDTO dto) {
		Optional<Card> card = cardRepository.findById(id);
		updateData(card, dto);
		
		return new CardDTO(card.get());
	}
	
	@Transactional
	public void delete(Long id) {
		Optional<Card> card = cardRepository.findById(id);
		cardRepository.deleteById(card.get().getId());
	}
	
	private void updateData(Optional<Card> card, CardDTO dto) {
		card.get().setCardNumber(dto.getCardNumber());
		card.get().setEmbossName(dto.getEmbossName());
		card.get().setCustomerName(dto.getCustomerName());
		card.get().setDocumentNumber(dto.getDocumentNumber());
		card.get().setMotherName(dto.getMotherName());
		card.get().setAddress(dto.getAddress());
		card.get().setCity(dto.getCity());
	}
}