package com.orbitallcorp.hack21.cards.domains.dto;

import java.io.Serializable;

import com.orbitallcorp.hack21.cards.domains.Card;

public class CardDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cardNumber;
	private String embossName;
	private String customerName;
	private String documentNumber;
	private String motherName;
	private String address;
	private String city;
	
	public CardDTO() {
	}
	
	public CardDTO(Card obj) {
		id = obj.getId();
		cardNumber = obj.getCardNumber();
		embossName = obj.getEmbossName();
		customerName = obj.getCustomerName();
		documentNumber = obj.getDocumentNumber();
		motherName = obj.getMotherName();
		address = obj.getAddress();
		city = obj.getCity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getEmbossName() {
		return embossName;
	}

	public void setEmbossName(String embossName) {
		this.embossName = embossName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}