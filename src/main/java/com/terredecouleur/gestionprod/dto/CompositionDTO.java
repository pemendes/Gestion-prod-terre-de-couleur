package com.terredecouleur.gestionprod.dto;

import java.io.Serializable;

public class CompositionDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Double quantity;
	private Integer materialId;
	
	public CompositionDTO() {
	}
	
	public CompositionDTO(Double quantity, Integer materialId) {
		super();
		this.quantity = quantity;
		this.materialId = materialId;
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
