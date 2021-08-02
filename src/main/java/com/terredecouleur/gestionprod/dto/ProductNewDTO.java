package com.terredecouleur.gestionprod.dto;

import java.io.Serializable;
import java.util.Calendar;

public class ProductNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String numberLot;
	private String name;
	private Calendar dateExpiry;
	private String observation;
	private String comment;	
	private Double quantity;
	private Integer materialId;
	
	public ProductNewDTO(String numberLot, String name, Calendar dateExpiry, String observation,
			String comment, Double quantity, Integer materialId) {
		super();
		this.numberLot = numberLot;
		this.name = name;
		this.dateExpiry = dateExpiry;
		this.observation = observation;
		this.comment = comment;
		this.quantity = quantity;
		this.materialId = materialId;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}
}
