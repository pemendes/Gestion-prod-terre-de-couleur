package com.terredecouleur.gestionprod.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.terredecouleur.gestionprod.models.Composition;
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
}
