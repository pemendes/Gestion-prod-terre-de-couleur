package com.terredecouleur.gestionprod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terredecouleur.gestionprod.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
