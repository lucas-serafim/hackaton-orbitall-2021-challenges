package com.orbitallcorp.hack21.cards.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	@Transactional(readOnly = true)
	public CardDTO findById(Long id) {
		Optional<Card> card = cardRepository.findById(id);
		return new CardDTO(card.get());
	}
	
	@Transactional(readOnly = true)
	public List<CardDTO> findAllPagination(Integer pageNo, Integer pageSize){
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
		Page<Card> pagedResult = cardRepository.findAll(paging);
        
        if(pagedResult.hasContent()) {
            return pagedResult.getContent().stream().map(x -> new CardDTO(x)).collect(Collectors.toList());
        } else {
            return new ArrayList<CardDTO>();
        }
	}
	
	private void updateData(Optional<Card> card, CardDTO dto) {
		card.get().setCardNumber((dto.getCardNumber() != "") ? dto.getCardNumber() : card.get().getCardNumber());
		card.get().setEmbossName((dto.getEmbossName() != "") ? dto.getEmbossName() : card.get().getEmbossName());
		card.get().setCustomerName((dto.getCustomerName() != "") ? dto.getCustomerName() : card.get().getCustomerName());
		card.get().setDocumentNumber((dto.getDocumentNumber() != "") ? dto.getDocumentNumber() : card.get().getDocumentNumber());
		card.get().setMotherName((dto.getMotherName() != "") ? dto.getMotherName() : card.get().getMotherName());
		card.get().setAddress((dto.getAddress() != "") ? dto.getAddress() : card.get().getAddress());
		card.get().setCity((dto.getCity() != "") ? dto.getCity() : card.get().getCity());
	}
}