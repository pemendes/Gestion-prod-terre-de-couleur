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

import com.terredecouleur.gestionprod.models.Provider;
import com.terredecouleur.gestionprod.services.ProviderService;

@RestController
@RequestMapping(value="/providers")
public class ProviderResource {
	
	@Autowired
	private ProviderService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findProviderById(@PathVariable Integer id) {
		Provider provider = service.findProviderById(id);
		return ResponseEntity.ok().body(provider);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Provider provider) {
		provider = service.insert(provider);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(provider.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
}
