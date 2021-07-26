package com.terredecouleur.gestionprod.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.terredecouleur.gestionprod.models.Provider;
import com.terredecouleur.gestionprod.repositories.ProviderRepository;
import com.terredecouleur.gestionprod.services.exceptions.DataIntegrityException;
import com.terredecouleur.gestionprod.services.exceptions.ObjectNotFoundException;

@Service
public class ProviderService {
	
	@Autowired
	private ProviderRepository repo;
	
	public Provider findProviderById(Integer id) {
		Optional<Provider> provider = repo.findById(id);
		return provider.orElseThrow(()->new ObjectNotFoundException("Objet non trouvé! Id: " + id + ", type: " + Provider.class.getName()));	
	}
	
	public List<Provider> findAll() {
		return repo.findAll();
	}
	
	public Provider insert(Provider provider) {
		provider.setId(null);
		return repo.save(provider);
	}
	
	public Provider update(Provider provider) {
		findProviderById(provider.getId());
		return repo.save(provider);
	}
	
	public void delete(Integer id) {
		findProviderById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Pas possible de supprimer un fournisseur qui possede des matières premières!");
		}
	}

	public Page<Provider> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
