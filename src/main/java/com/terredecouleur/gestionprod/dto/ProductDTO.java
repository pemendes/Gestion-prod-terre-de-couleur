package com.terredecouleur.gestionprod.dto;

import java.io.Serializable;
import java.util.Calendar;

public class ProductDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String numberLot;
	private String name;
	private Calendar dateExpiry;
	private String observation;
	private String comment;
	
	public ProductDTO(Integer id, String numberLot, String name, Calendar dateExpiry, String observation,
			String comment) {
		super();
		this.id = id;
		this.numberLot = numberLot;
		this.name = name;
		this.dateExpiry = dateExpiry;
		this.observation = observation;
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumberLot() {
		return numberLot;
	}

	public void setNumberLot(String numberLot) {
		this.numberLot = numberLot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getDateExpiry() {
		return dateExpiry;
	}

	public void setDateExpiry(Calendar dateExpiry) {
		this.dateExpiry = dateExpiry;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
