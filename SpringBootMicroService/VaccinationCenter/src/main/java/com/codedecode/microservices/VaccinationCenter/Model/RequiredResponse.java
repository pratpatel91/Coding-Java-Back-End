package com.codedecode.microservices.VaccinationCenter.Model;

import java.util.List;

import com.codedecode.microservices.VaccinationCenter.Entity.VaccinationCenter;

public class RequiredResponse {
	
	private VaccinationCenter center;
	private List<Citizen> citizens;
	
	//Removed Lombok Annotations & manually wrote 
	//Getter & Setter Functions for all instance variables
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	

}

