package com.luisfelipebp.wirecardspring;

import com.luisfelipebp.wirecardspring.model.Buyer;
import com.luisfelipebp.wirecardspring.model.Card;
import com.luisfelipebp.wirecardspring.model.Client;
import com.luisfelipebp.wirecardspring.model.Payment;
import com.luisfelipebp.wirecardspring.model.enums.MethodPayment;
import com.luisfelipebp.wirecardspring.repository.BuyerRepository;
import com.luisfelipebp.wirecardspring.repository.ClientRepository;
import com.luisfelipebp.wirecardspring.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class WirecardSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WirecardSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ClientRepository clientRepository, BuyerRepository buyerRepository, PaymentRepository paymentRepository) {
		return args -> {
//			Client cliente = new Client(null);
//			Card card = new Card("Luis Felicio", "1234 4567 8910", new Date("14/09/2050"),"156");
//			Buyer buyer = new Buyer(null, "Luis", "luis@gmail.com", "1232341214");
//			Payment payment = new Payment(null, 100.00, MethodPayment.CARD, card, buyer, cliente);
//			clientRepository.save(cliente);
//			buyerRepository.save(buyer);
//			paymentRepository.save(payment);

		};
	}

}
