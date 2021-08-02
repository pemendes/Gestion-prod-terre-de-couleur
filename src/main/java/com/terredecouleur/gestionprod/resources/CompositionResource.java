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

import com.terredecouleur.gestionprod.dto.CompositionDTO;
import com.terredecouleur.gestionprod.models.Composition;
import com.terredecouleur.gestionprod.services.CompositionService;

@RestController
@RequestMapping(value="/compositions")
public class CompositionResource {

	@Autowired
	private CompositionService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Composition> findCompositionById(@PathVariable Integer id) {
		Composition composition = service.findCompositionById(id);
		return ResponseEntity.ok().body(composition);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Composition>> findAll() {
		List<Composition> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CompositionDTO objDto) {
		Composition composition = service.fromNewDTO(objDto);
		composition = service.insert(composition);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(composition.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CompositionDTO objDto, @PathVariable Integer id) {
		Composition Composition = service.fromDTO(objDto);
		Composition.setId(id);
		Composition = service.update(Composition);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Composition>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Composition> list = service.findPage(page, linesPerPage, orderBy, direction);
		  
		return ResponseEntity.ok().body(list);
	}
}
