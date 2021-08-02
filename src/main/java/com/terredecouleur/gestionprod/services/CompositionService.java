package com.terredecouleur.gestionprod.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terredecouleur.gestionprod.dto.CompositionDTO;
import com.terredecouleur.gestionprod.models.Composition;
import com.terredecouleur.gestionprod.models.Material;
import com.terredecouleur.gestionprod.repositories.CompositionRepository;
import com.terredecouleur.gestionprod.repositories.MaterialRepository;
import com.terredecouleur.gestionprod.services.exceptions.DataIntegrityException;
import com.terredecouleur.gestionprod.services.exceptions.ObjectNotFoundException;

@Service
public class CompositionService {

	@Autowired
	private CompositionRepository repo;
	
	@Autowired
	MaterialRepository matRepo;
	
	@Autowired
	private MaterialService matService;
	
	public Composition findCompositionById(Integer id) {
		Optional<Composition> composition = repo.findById(id);
		return composition.orElseThrow(()->new ObjectNotFoundException("Objet non trouvé! Id: " + id + ", type: " + Composition.class.getName()));
	}
	
	public List<Composition> findAll() {
		return repo.findAll();
	}
	
	@Transactional
	public Composition insert(Composition composition) {
		Material mat = composition.getMaterial();
		if (mat.getStockActual() >= composition.getQuantity()) {
			composition.setId(null);
			composition =  repo.save(composition);
			
			mat.setStockActual(mat.getStockActual() - composition.getQuantity());
			mat.setQuatityProd(mat.getQuatityProd() + composition.getQuantity());
			matService.update(mat);
			return composition;
		} else {
			throw new ObjectNotFoundException("Le stock de " + mat.getTradeName() + " est insufisant!");
		}	
	}
	
	public Composition update(Composition obj) {
		Composition newObj = findCompositionById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		findCompositionById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Pas possible de supprimer une composition première qui est liée à d'autres entités!");
		}
	}

	public Page<Composition> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Composition fromDTO(CompositionDTO objDto) {
		Composition Composition = new Composition(null, objDto.getQuantity(), null);
		return Composition;
	}
	
	public Composition fromNewDTO(CompositionDTO objNewDto) {
		// Material mat = new Material(objNewDto.getMaterialId(), null, null, null, null, null, null, null, null, null, null);
		Material mat = matService.findMaterialById(objNewDto.getMaterialId());
		Composition Composition = new Composition(null, objNewDto.getQuantity(), mat);
		// mat.setStockActual(mat.getStockActual() - objNewDto.getQuantity());
		// mat.setQuatityProd(mat.getQuatityProd() + objNewDto.getQuantity());
		return Composition;
	}
	
	private void updateData(Composition newObj, Composition obj) {
		newObj.setQuantity(obj.getQuantity());
		newObj.setMaterial(obj.getMaterial());
	}

}
