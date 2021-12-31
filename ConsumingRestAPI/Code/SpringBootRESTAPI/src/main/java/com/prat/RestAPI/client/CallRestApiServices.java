package com.prat.RestAPI.client;

import org.json.JSONException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prat.RestAPI.Model.Person;

@Component
public class CallRestApiServices implements CommandLineRunner {
	private static RestTemplate restTemplate = new RestTemplate();
	private static final String GET_PERSON_BY_ID_API = "http://localhost:8080/persons/1";
	private static final String GET_ALL_PEOPLE_API = "http://localhost:8080/persons/all";

	public static void fetchDataByCallingRestApiService_getPersonById()
			throws JsonMappingException, JsonProcessingException {
		String apisSerializedJSONString = restTemplate.getForObject(GET_PERSON_BY_ID_API, String.class);
		System.out.println(apisSerializedJSONString);

		ObjectMapper objectMapper = new ObjectMapper();
		Person deserializedJSONObject = objectMapper.readValue(apisSerializedJSONString, Person.class);
		System.out.println("FName:" + deserializedJSONObject.getFirstName() + ", " + "LName:"
				+ deserializedJSONObject.getLastName());
	}

	public static void getcallRestApiService_getAllPeople()
			throws JsonMappingException, JsonProcessingException, JSONException {
		String apisSerializedJSONString = restTemplate.getForObject(GET_ALL_PEOPLE_API, String.class);
		System.out.println(apisSerializedJSONString);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\n\nFetching data by calling RestApiService_getPersonById() ");
		fetchDataByCallingRestApiService_getPersonById();
		System.out.println("\n\n\nFetching data by calling RestApiService_getAllPeople() ");
		getcallRestApiService_getAllPeople();
	}
}
