package com.terredecouleur.gestionprod.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terredecouleur.gestionprod.models.Composition;
import com.terredecouleur.gestionprod.repositories.CompositionRepository;

@Service
public class CompositionService {

	@Autowired
	private CompositionRepository repo;
	
	public Composition findCompositionById(Integer id) {
		Optional<Composition> composition = repo.findById(id);
		return composition.orElse(null);
	}

}
