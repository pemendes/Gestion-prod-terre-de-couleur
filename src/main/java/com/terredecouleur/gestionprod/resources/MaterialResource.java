package com.terredecouleur.gestionprod.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.terredecouleur.gestionprod.dto.MaterialDTO;
import com.terredecouleur.gestionprod.dto.MaterialNewDTO;
import com.terredecouleur.gestionprod.models.Material;
import com.terredecouleur.gestionprod.services.MaterialService;

@RestController
@RequestMapping(value="/materials")
public class MaterialResource {
	
	@Autowired
	MaterialService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Material> findMaterialById(@PathVariable Integer id) {
		Material material = service.findMaterialById(id);
		return ResponseEntity.ok().body(material);	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Material>> findAll() {
		List<Material> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody MaterialNewDTO objNewDto) {
		Material material = service.fromDTO(objNewDto);
		material = service.insert(material);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(material.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody MaterialDTO objDto, @PathVariable Integer id) {
		Material material = service.fromDTO(objDto);
		material.setId(id);
		material = service.update(material);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Material>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Material> list = service.findPage(page, linesPerPage, orderBy, direction);
		  
		return ResponseEntity.ok().body(list);
	}

}
