package com.terredecouleur.gestionprod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terredecouleur.gestionprod.models.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer>{

}
