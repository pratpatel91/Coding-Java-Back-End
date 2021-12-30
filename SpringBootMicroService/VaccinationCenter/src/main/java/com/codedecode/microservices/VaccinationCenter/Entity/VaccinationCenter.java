package com.codedecode.microservices.VaccinationCenter.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Entity=Table
@Entity
public class VaccinationCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String centerName;

	@Column
	private String centerAddress;

	//Removed Lombok Annotations & manually wrote 
	//Getter & Setter Functions for all instance variables
	public String getCenterAddress() {
		return centerAddress;
	}

	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

}
