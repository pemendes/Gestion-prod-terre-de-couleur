package com.terredecouleur.gestionprod.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terredecouleur.gestionprod.models.Provider;
import com.terredecouleur.gestionprod.repositories.ProviderRepository;

@Service
public class ProviderService {
	
	@Autowired
	private ProviderRepository repo;
	
	public Provider findProviderById(Integer id) {
		Optional<Provider> provider = repo.findById(id);
		return provider.orElse(null);
	}

}
