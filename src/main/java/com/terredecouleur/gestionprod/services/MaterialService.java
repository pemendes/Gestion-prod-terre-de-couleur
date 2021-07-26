package com.terredecouleur.gestionprod.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terredecouleur.gestionprod.models.Material;
import com.terredecouleur.gestionprod.repositories.MaterialRepository;
import com.terredecouleur.gestionprod.services.exceptions.ObjectNotFoundException;

@Service
public class MaterialService {

	@Autowired
	MaterialRepository repo;
	
	public Material findMaterialById(Integer id) {
		Optional<Material> material = repo.findById(id);
		return material.orElseThrow(()->new ObjectNotFoundException("Objet non trouvé! Id: " + id + ", type: " + Material.class.getName()));	
	}
	
	public Material insert(Material material) {
		material.setId(null);
		return repo.save(material);
	}
}
