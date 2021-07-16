package com.terredecouleur.gestionprod.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/providers")
public class ProviderResource {

	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		
		return "REST is OK!";
	}
}
