package com.terredecouleur.gestionprod.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.terredecouleur.gestionprod.models.Provider;

@RestController
@RequestMapping(value="/providers")
public class ProviderResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Provider> list() {
		
		Provider p1 = new Provider(1, "Cosmos", "7 rue Louis Niqueux", "37000");
		Provider p2 = new Provider(2, "Pettra", "102 rue Louis Pasteur", "45000");
		
		List<Provider> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		
		return list;
	}
}
