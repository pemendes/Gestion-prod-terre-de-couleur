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

import com.terredecouleur.gestionprod.dto.MaterialDTO;
import com.terredecouleur.gestionprod.dto.MaterialNewDTO;
import com.terredecouleur.gestionprod.models.Material;
import com.terredecouleur.gestionprod.models.Provider;
import com.terredecouleur.gestionprod.repositories.MaterialRepository;
import com.terredecouleur.gestionprod.services.exceptions.DataIntegrityException;
import com.terredecouleur.gestionprod.services.exceptions.ObjectNotFoundException;

@Service
public class MaterialService {

	@Autowired
	MaterialRepository repo;
	
	public Material findMaterialById(Integer id) {
		Optional<Material> material = repo.findById(id);
		return material.orElseThrow(()->new ObjectNotFoundException("Objet non trouvé! Id: " + id + ", type: " + Material.class.getName()));	
	}
	
	public List<Material> findAll() {
		return repo.findAll();
	}
	
	@Transactional
	public Material insert(Material material) {
		material.setId(null);
		return repo.save(material);
	}
	
	public Material update(Material obj) {
		Material newObj = findMaterialById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		findMaterialById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Pas possible de supprimer une matière première qui est liée à un fournisseur!");
		}
	}

	public Page<Material> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Material fromDTO(MaterialDTO objDto) {
		Material material = new Material(objDto.getId(), objDto.getNumberLot(), objDto.getDesignation(), 
				objDto.getTradeName(), objDto.getDateManufacture(), objDto.getDateExpiry(), 
				objDto.getStockProduction(), 0.00, 0.00, objDto.getPriceKg(), null);
		
		return material;
	}
	
	public Material fromDTO(MaterialNewDTO objNewDto) {
		Provider pr = new Provider(objNewDto.getProviderId(), null, null, null);
		Material material = new Material(null, objNewDto.getNumberLot(), objNewDto.getDesignation(), 
				objNewDto.getTradeName(), objNewDto.getDateManufacture(), objNewDto.getDateExpiry(), 
				objNewDto.getStockProduction(), objNewDto.getStockProduction(), 0.00, objNewDto.getPriceKg(), pr);
		
		return material;
	}
	
	private void updateData(Material newObj, Material obj) {
		newObj.setNumberLot(obj.getNumberLot());
		newObj.setDesignation(obj.getDesignation());
		newObj.setTradeName(obj.getTradeName());
		newObj.setDateManufacture(obj.getDateManufacture());
		newObj.setDateExpiry(obj.getDateExpiry());
	}
}
