package com.terredecouleur.gestionprod.dto;

import java.io.Serializable;
import java.util.Calendar;

public class MaterialNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String numberLot;
	private String designation;
	private String tradeName;
	private Calendar dateManufacture;
	private Calendar dateExpiry;
	private Double stockProduction;
	private Double priceKg;
	private Integer providerId;
	
	public MaterialNewDTO() {
	}

	public MaterialNewDTO(String numberLot, String designation, String tradeName, Calendar dateManufacture,
			Calendar dateExpiry, Double stockProduction, Double priceKg, Integer providerId) {
		super();
		this.numberLot = numberLot;
		this.designation = designation;
		this.tradeName = tradeName;
		this.dateManufacture = dateManufacture;
		this.dateExpiry = dateExpiry;
		this.stockProduction = stockProduction;
		this.priceKg = priceKg;
		this.providerId = providerId;
	}

	public String getNumberLot() {
		return numberLot;
	}

	public void setNumberLot(String numberLot) {
		this.numberLot = numberLot;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public Calendar getDateManufacture() {
		return dateManufacture;
	}

	public void setDateManufacture(Calendar dateManufacture) {
		this.dateManufacture = dateManufacture;
	}

	public Calendar getDateExpiry() {
		return dateExpiry;
	}

	public void setDateExpiry(Calendar dateExpiry) {
		this.dateExpiry = dateExpiry;
	}

	public Double getStockProduction() {
		return stockProduction;
	}

	public void setStockProduction(Double stockProduction) {
		this.stockProduction = stockProduction;
	}

	public Double getPriceKg() {
		return priceKg;
	}

	public void setPriceKg(Double priceKg) {
		this.priceKg = priceKg;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
}
