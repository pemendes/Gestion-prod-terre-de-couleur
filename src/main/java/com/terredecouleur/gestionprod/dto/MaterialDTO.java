package com.terredecouleur.gestionprod.dto;

import java.io.Serializable;
import java.util.Calendar;

import com.terredecouleur.gestionprod.models.Material;

public class MaterialDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String numberLot;
	private String designation;
	private String tradeName;
	private Calendar dateManufacture;
	private Calendar dateExpiry;
	private Double stockProduction;
	private Double priceKg;
	
	public MaterialDTO() {
	}
	
	public MaterialDTO(Material obj) {
		id = obj.getId();
		numberLot = obj.getNumberLot();
		designation = obj.getDesignation();
		tradeName = obj.getTradeName();
		dateManufacture = getDateManufacture();
		dateExpiry = obj.getDateExpiry();
		stockProduction = obj.getStockProduction();
		priceKg = obj.getPriceKg();
	}

	public MaterialDTO(Integer id, String numberLot, String designation, String tradeName, Calendar dateManufacture,
			Calendar dateExpiry, Double stockProduction, Double priceKg) {
		super();
		this.id = id;
		this.numberLot = numberLot;
		this.designation = designation;
		this.tradeName = tradeName;
		this.dateManufacture = dateManufacture;
		this.dateExpiry = dateExpiry;
		this.stockProduction = stockProduction;
		this.priceKg = priceKg;
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
}
