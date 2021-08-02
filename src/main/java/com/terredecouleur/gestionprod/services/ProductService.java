package com.terredecouleur.gestionprod.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terredecouleur.gestionprod.dto.ProductDTO;
import com.terredecouleur.gestionprod.dto.ProductNewDTO;
import com.terredecouleur.gestionprod.models.Composition;
import com.terredecouleur.gestionprod.models.Material;
import com.terredecouleur.gestionprod.models.Product;
import com.terredecouleur.gestionprod.repositories.CompositionRepository;
import com.terredecouleur.gestionprod.repositories.ProductRepository;
import com.terredecouleur.gestionprod.services.exceptions.DataIntegrityException;
import com.terredecouleur.gestionprod.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private MaterialService matService;
	
	@Autowired
	CompositionRepository compositionRepo;
	
	public Product findProductById(Integer id) {
		Optional<Product> product = repo.findById(id);
		return product.orElseThrow(()->new ObjectNotFoundException("Objet non trouvé! Id: " + id + ", type: " + Product.class.getName()));	
	}
	
	public List<Product> findAll() {
		return repo.findAll();
	}
	
	@Transactional
	public Product insert(Product product) {
		product.setId(null);
		product = repo.save(product);
		
		for (Composition comp : product.getCompositions()) {
			Material mat = comp.getMaterial();
			if (mat.getStockActual() >= comp.getQuantity()) {
				comp.setId(null);
				compositionRepo.save(comp);
				mat.setStockActual(mat.getStockActual() - comp.getQuantity());
				mat.setQuatityProd(mat.getQuatityProd() + comp.getQuantity());
				matService.update(mat);
			} else {
				throw new ObjectNotFoundException("Le stock de " + mat.getTradeName() + " est insufisant!");
			}	
		}
		return product;
	}
	
	public Product update(Product obj) {
		Product newObj = findProductById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		findProductById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Pas possible de supprimer un produit qui est liée à d'autres entités!");
		}
	}

	public Page<Product> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Product fromDTO(ProductDTO objDto) {
		Product Product = new Product(objDto.getId(), objDto.getNumberLot(), objDto.getName(), 
				null, objDto.getDateExpiry(), 0.00, objDto.getObservation(), objDto.getComment());
		return Product;
	}
	
	public Product fromDTO(ProductNewDTO objNewDto) {
		Material mat = matService.findMaterialById(objNewDto.getMaterialId());
		Composition Composition = new Composition(null, objNewDto.getQuantity(), mat);
		
		Product product = new Product(null, objNewDto.getNumberLot(), objNewDto.getName(), 
				Calendar.getInstance(), objNewDto.getDateExpiry(), 0.00, objNewDto.getObservation(), objNewDto.getComment());
		product.getCompositions().add(Composition);
		
		Double totalQty = 0.00;
		for (Composition comp : product.getCompositions()) {
			totalQty += comp.getQuantity();
		}
		product.setTotalQuatity(totalQty);	
		return product;
	}
	
	private void updateData(Product newObj, Product obj) {
		newObj.setNumberLot(obj.getNumberLot());
		newObj.setName(obj.getName());
		newObj.setDateExpiry(obj.getDateExpiry());
		newObj.setObservation(obj.getObservation());
		newObj.setComment(obj.getComment());
	}
}
