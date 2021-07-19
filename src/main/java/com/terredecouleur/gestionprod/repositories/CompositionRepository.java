package com.terredecouleur.gestionprod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terredecouleur.gestionprod.models.Composition;

@Repository
public interface CompositionRepository extends JpaRepository<Composition, Integer>{

}
