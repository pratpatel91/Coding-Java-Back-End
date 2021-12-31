package com.prat.RestAPI.Service;

import java.util.Hashtable;
import org.springframework.stereotype.Service;
import com.prat.RestAPI.Model.Person;

@Service
public class PersonService {

	// Data Structure
	Hashtable<String, Person> allPeoplesHashTable = 
			new Hashtable<String, Person>();

	// Constructor (populating the data structure)
	public PersonService() {
		// create object
		Person p1 = new Person();
		p1.setId("1");
		p1.setAge(21);
		p1.setFirstName("Pratiksh");
		p1.setLastName("Patel");
		// add object into data structure
		allPeoplesHashTable.put("1", p1);

		// create object
		Person p2 = new Person();
		p2.setId("2");
		p2.setAge(21);
		p2.setFirstName("Anjali");
		p2.setLastName("Patel");
		// add object into data structure
		allPeoplesHashTable.put("2", p2);
	}

	// returning back the person object with matching
	// id only
	public Person getPersonById(String id) {
		if (allPeoplesHashTable.containsKey(id)) {
			// accessing person object in O(1) time
			return allPeoplesHashTable.get(id);
		} else {
			return null;
		}
	}

	// returning back the entire populated
	// datastructure
	public Hashtable<String, Person> getAllPeople() {
		return allPeoplesHashTable;
	}
}
