package com.terredecouleur.gestionprod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terredecouleur.gestionprod.models.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer>{

}
