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

import com.terredecouleur.gestionprod.models.Composition;
import com.terredecouleur.gestionprod.models.Provider;
import com.terredecouleur.gestionprod.services.CompositionService;

@RestController
@RequestMapping(value="/compositions")
public class CompositionResource {

	@Autowired
	private CompositionService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findCompositionById(@PathVariable Integer id) {
		Composition composition = service.findCompositionById(id);
		return ResponseEntity.ok().body(composition);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Composition composition) {
		composition = service.insert(composition);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(composition.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
}
