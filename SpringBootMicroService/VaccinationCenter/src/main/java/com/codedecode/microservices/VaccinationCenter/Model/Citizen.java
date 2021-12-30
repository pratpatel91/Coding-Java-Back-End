package com.codedecode.microservices.VaccinationCenter.Model;

public class Citizen {
	
	private int id;
	private String name;
	private int vaccinationCenterId;

	//Removed Lombok Annotations & manually wrote 
	//Getter & Setter Functions for all instance variables
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVaccinationCenterId() {
		return vaccinationCenterId;
	}

	public void setVaccinationCenterId(int vaccinationCenterId) {
		this.vaccinationCenterId = vaccinationCenterId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
