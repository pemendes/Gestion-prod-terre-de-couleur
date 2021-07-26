package com.terredecouleur.gestionprod.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.terredecouleur.gestionprod.models.Material;
import com.terredecouleur.gestionprod.services.MaterialService;

@RestController
@RequestMapping(value="/materials")
public class MaterialResource {
	
	@Autowired
	MaterialService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findMaterialById(@PathVariable Integer id) {
		Material material = service.findMaterialById(id);
		return ResponseEntity.ok().body(material);	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Material material) {
		material = service.insert(material);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(material.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}

}
