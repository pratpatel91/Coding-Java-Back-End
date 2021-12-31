package com.prat.RestAPI.Controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prat.RestAPI.Model.Person;
import com.prat.RestAPI.Service.PersonService;

@RestController
@RequestMapping("/persons")

public class PersonController {

	@Autowired
	PersonService personService; // Controller depends on service

	@RequestMapping("/hello")
	public String testingAPIEndPoints() {
		return "apiEndpoint is hit";
	}

	// INPUT: User hits REST API End Point = http://localhost:8080/persons/all
	// OUTPUT: User sees JSON data (list of all people)
	@RequestMapping("/all")
	public Hashtable<String, Person> getAllPeople() {
		return personService.getAllPeople();
	}

	// INPUT: User hits REST API End Point = http://localhost:8080/persons/id
	// OUTPUT: User sees data (people with matching id)
	@RequestMapping("{id}")
	public Person getPersonById(@PathVariable("id") String id) {
		return personService.getPersonById(id);
	}
}
