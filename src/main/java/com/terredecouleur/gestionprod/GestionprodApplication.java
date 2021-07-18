package com.terredecouleur.gestionprod;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.terredecouleur.gestionprod.models.Provider;
import com.terredecouleur.gestionprod.repositories.ProviderRepository;

@SpringBootApplication
public class GestionprodApplication implements CommandLineRunner {
	
	@Autowired
	private ProviderRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(GestionprodApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Provider p1 = new Provider(null, "Cosmos", "7 Rue Louis Niqueux", "37000");
		Provider p2 = new Provider(null, "Terramus", "102 Rue Pasteur", "45000");
		Provider p3 = new Provider(null, "Assemblor", "25 Rue Daniel Mayer", "37100");
		
		repo.saveAll(Arrays.asList(p1, p2, p3));
		
	}

}
