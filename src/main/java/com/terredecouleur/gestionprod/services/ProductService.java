package com.terredecouleur.gestionprod.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terredecouleur.gestionprod.models.Product;
import com.terredecouleur.gestionprod.repositories.ProductRepository;
import com.terredecouleur.gestionprod.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public Product findProductById(Integer id) {
		Optional<Product> product = repo.findById(id);
		return product.orElseThrow(()->new ObjectNotFoundException("Objet non trouvé! Id: " + id + ", type: " + Product.class.getName()));	
	}
}
