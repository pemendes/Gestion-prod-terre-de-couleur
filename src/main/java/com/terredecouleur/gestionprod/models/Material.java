package com.terredecouleur.gestionprod.models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Material implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String numberLot;
	private String designation;
	private String tradeName;
	private Calendar dateManufacture;
	private Calendar dateExpiry;
	private Double StockProduction;
	private Double stockActual;
	private Double quatityProd;
	private Double priceKg;
	
	@ManyToOne
	@JoinColumn(name = "provider_id")
	private Provider provider;
	
	public Material() {
	}

	public Material(Integer id, String numberLot, String designation, String tradeName, Calendar dateManufacture,
			Calendar dateExpiry, Double stockProduction, Double stockActual, Double quatityProd, Double priceKg,
			Provider provider) {
		this.id = id;
		this.numberLot = numberLot;
		this.designation = designation;
		this.tradeName = tradeName;
		this.dateManufacture = dateManufacture;
		this.dateExpiry = dateExpiry;
		StockProduction = stockProduction;
		this.stockActual = stockActual;
		this.quatityProd = quatityProd;
		this.priceKg = priceKg;
		this.provider = provider;
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
		return StockProduction;
	}

	public void setStockProduction(Double stockProduction) {
		StockProduction = stockProduction;
	}

	public Double getStockActual() {
		return stockActual;
	}

	public void setStockActual(Double stockActual) {
		this.stockActual = stockActual;
	}

	public Double getQuatityProd() {
		return quatityProd;
	}

	public void setQuatityProd(Double quatityProd) {
		this.quatityProd = quatityProd;
	}

	public Double getPriceKg() {
		return priceKg;
	}

	public void setPriceKg(Double priceKg) {
		this.priceKg = priceKg;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
