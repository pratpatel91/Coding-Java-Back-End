package com.prat.RestAPI.Model;

public class Person {
	// instance variables
	private String id;
	private String firstName;
	private String lastName;
	private int age;

	// no args empty constructor
	public Person() {
	}

	// Getter & Setter Functions for
	// all instance variables
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
