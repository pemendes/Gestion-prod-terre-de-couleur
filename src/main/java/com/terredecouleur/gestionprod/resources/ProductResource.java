package com.terredecouleur.gestionprod.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.terredecouleur.gestionprod.models.Product;
import com.terredecouleur.gestionprod.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findProductById(@PathVariable Integer id) {
		Product product = service.findProductById(id);
		return ResponseEntity.ok().body(product);
	}
}
