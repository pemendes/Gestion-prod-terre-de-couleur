package com.terredecouleur.gestionprod;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.terredecouleur.gestionprod.models.Composition;
import com.terredecouleur.gestionprod.models.Material;
import com.terredecouleur.gestionprod.models.Product;
import com.terredecouleur.gestionprod.models.Provider;
import com.terredecouleur.gestionprod.repositories.CompositionRepository;
import com.terredecouleur.gestionprod.repositories.MaterialRepository;
import com.terredecouleur.gestionprod.repositories.ProductRepository;
import com.terredecouleur.gestionprod.repositories.ProviderRepository;

@SpringBootApplication
public class GestionprodApplication implements CommandLineRunner {
	
	@Autowired
	private ProviderRepository providerRepo;
	@Autowired
	private MaterialRepository materialRepo;
	@Autowired
	CompositionRepository compositionRepo;
	@Autowired
	ProductRepository productRepo;

	public static void main(String[] args) {
		SpringApplication.run(GestionprodApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Provider p1 = new Provider(null, "Cosmos", "7 Rue Louis Niqueux", "37000");
		Provider p2 = new Provider(null, "Terramus", "102 Rue Pasteur", "45000");
		Provider p3 = new Provider(null, "Assemblor", "25 Rue Daniel Mayer", "37100");
		
		Material mat1 = new Material(null, "NTRRD12", "Errylite 231", "Errylite", Calendar.getInstance(), 
				Calendar.getInstance(), 20.00, 20.00, 0.00, 4.95, p1);
		Material mat2 = new Material(null, "XYRRD12", "Palmas Y5", "Palmassim", Calendar.getInstance(), 
				Calendar.getInstance(), 20.00, 20.00, 0.00, 3.95, p2);
		Material mat3 = new Material(null, "FFRRD12", "Torrimus 443", "Torrimus", Calendar.getInstance(), 
				Calendar.getInstance(), 25.00, 25.00, 0.00, 5.95, p1);
		Material mat4 = new Material(null, "001FFRRD12", "Astrazeneca 443", "Astraz", Calendar.getInstance(), 
				Calendar.getInstance(), 25.00, 25.00, 0.00, 5.95, null);
		
		Composition c1 = new Composition(null, 5.00, mat1);
		Composition c2 = new Composition(null, 10.00, mat2);
		Composition c3 = new Composition(null, 6.00, mat3);
		
		Product prod = new Product(null, "TEX001", "Baum fom", Calendar.getInstance(), 
				Calendar.getInstance(), 15.00, "Rien à signaler", "Rien à signaler");
		prod.setCompositions(Arrays.asList(c1, c2));
		
		Product prod1 = new Product(null, "TEX002", "Champoing fom", Calendar.getInstance(), 
				Calendar.getInstance(), 6.00, "Rien à signaler", "Rien à signaler");
		prod1.setCompositions(Arrays.asList(c3));
			
		
		providerRepo.saveAll(Arrays.asList(p1, p2, p3));
		materialRepo.saveAll(Arrays.asList(mat1, mat2, mat3, mat4));
		compositionRepo.saveAll(Arrays.asList(c1, c2, c3));
		productRepo.saveAll(Arrays.asList(prod, prod1));
	}

}
