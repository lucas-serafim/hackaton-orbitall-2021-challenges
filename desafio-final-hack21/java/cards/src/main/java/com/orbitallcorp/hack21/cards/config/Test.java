package com.orbitallcorp.hack21.cards.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.repositories.CardRepository;

@Configuration
@Profile("test")
public class Test implements CommandLineRunner {

	@Autowired
	private CardRepository cardRepository;

	@Override
	public void run(String... args) throws Exception {
		cardRepository.deleteAll();
		
		Card card = new Card(null, "1234.1234.1234.1234", "test", "test", "121231231", "test", "test", "test");
		
		cardRepository.save(card);
	}
}