package com.codedecode.microservices.CitizenService.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codedecode.microservices.CitizenService.Entity.Citizen;
import com.codedecode.microservices.CitizenService.Repo.CitizenRepo;

@RestController
@RequestMapping("/citizen")  	
public class CitizenController {
	
	@Autowired
	private CitizenRepo repo;

	//--------http://localhost:8081/citizen/id/1
	@RequestMapping(path = "/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {
		List<Citizen> listCitizen = repo.findByVaccinationCenterId(id);
		return new ResponseEntity<>(listCitizen, HttpStatus.OK);
	}
	
	//--------http://localhost:8081/citizen/add
	@PostMapping(path = "/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen) {
		System.out.println("executing function for handling post request: CitizenController Class -> addCitizen() ");
		Citizen savedCitizen = repo.save(newCitizen);
		return new ResponseEntity<>(savedCitizen, HttpStatus.OK);
	}
}
