package com.terredecouleur.gestionprod.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String numberLot;
	private String name;
	private Calendar dateManufacture;
	private Calendar dateExpiry;
	private Double totalQuatity;
	
	@ManyToMany
	 @JoinTable(name = "PRODUCT_COMPOSITION",
	 joinColumns = @JoinColumn(name = "product_id"),
	 inverseJoinColumns = @JoinColumn(name = "composition_id")
	 ) 
	private List<Composition> compositions = new ArrayList<>();
	
	@Column(columnDefinition = "text")
	private String observation;
	
	@Column(columnDefinition = "text")
	private String comment;
	
	public Product() {	
	}

	public Product(Integer id, String numberLot, String name, Calendar dateManufacture, Calendar dateExpiry,
			Double totalQuatity, String observation, String comment) {
		this.id = id;
		this.numberLot = numberLot;
		this.name = name;
		this.dateManufacture = dateManufacture;
		this.dateExpiry = dateExpiry;
		this.totalQuatity = totalQuatity;
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

	public Double getTotalQuatity() {
		return totalQuatity;
	}

	public void setTotalQuatity(Double totalQuatity) {
		this.totalQuatity = totalQuatity;
	}

	public List<Composition> getCompositions() {
		return compositions;
	}

	public void setCompositions(List<Composition> compositions) {
		this.compositions = compositions;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
