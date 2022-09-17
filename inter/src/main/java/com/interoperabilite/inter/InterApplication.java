package com.interoperabilite.inter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterApplication implements CommandLineRunner {
	
	@Autowired(required = true)
	private CommandeRepository commandeRepo;

	public static void main(String[] args) {
		SpringApplication.run(InterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		commandeRepo.findAll().forEach(commande -> System.out.println(commande.getId()));
	}

}
