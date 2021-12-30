package com.codedecode.microservices.CitizenService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Entity=Table
@Entity
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;

	@Column
	private int vaccinationCenterId;

	//Removed Lombok Annotations & manually wrote 
	//Getter & Setter Functions for all instance variables
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public int getVaccinationCenterId()
	{
		return vaccinationCenterId;
	}
	
	public void setVaccinationCenterId(int vaccinationCenterId)
	{
		this.vaccinationCenterId=vaccinationCenterId;
	}
}
