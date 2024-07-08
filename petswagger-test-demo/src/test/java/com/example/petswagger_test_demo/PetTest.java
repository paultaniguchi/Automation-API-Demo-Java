package com.example.petswagger_test_demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.petswagger_test_demo.models.Pet;
import com.example.petswagger_test_demo.models.Category;
import com.example.petswagger_test_demo.models.Tags;

import io.restassured.RestAssured;

import java.util.List;
import java.util.Arrays;

/**
 * Test for the Swagger Pet Store API
 * at https://petstore.swagger.io
 * 
 * Author: Paul Taniguchi
 */
public class PetTest 
{
	private static Logger logger = LoggerFactory.getLogger(PetTest.class);
	
	// set up test data 
	private int petId = 1000;
	private String petIdEndpoint = "/" + Integer.toString(petId);
	private Category expCategory = new Category(1001,"Fish");
	private Tags expTags = new Tags(1002,"Taco");
	private List<Tags> expTagList = Arrays.asList(expTags);
	private List<String> expPhotoUrl = Arrays.asList("https://www.example.com/photo1.jpg",
			"https://www.example.com/photo2.jpg");
	private Pet expPet = new Pet(petId, expCategory, "Furd", expPhotoUrl, expTagList, "pending");
	private static final int HTTP_STATUS_OK = 200;
	
	
	/*
	 *  when API request does not return status 200
	 *  log an ERROR with errorMessage
	 *  log a DEBUG with the response status
	 */
	private void logForErrorResponse(int responseStatus, String responseStatusLine, String errorMessage)
	{
		if (responseStatus != HTTP_STATUS_OK)
			// ERROR log
			logger.error(errorMessage);
			// DEBUG log
			logger.debug("The request returned: {}", responseStatusLine);
	}
	
	
	/*
	 *  put in the test pet
	 */
	@BeforeClass
	public void SetUp()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
		
		// create the pet in swagger.io that is used in the GET test
		var response = given().
			contentType("application/json").
			body(expPet).	
				when().
					post();
		
		// Log error if test pet was not created
		logForErrorResponse(response.getStatusCode(), response.getStatusLine(), "Failed to create test pet");
	}
	


	/*
	 * check that the GET request returns correct pet by
	 * checking each item in the response json
	 */
	@Test()
	public void testGetPet()
	{
		logger.info("Executing GET request test");
		
		given().
			when().
				get(petIdEndpoint).
			then().
				assertThat().
					statusCode(200).
					body("id", equalTo(expPet.getId())).
					body("name", equalTo(expPet.getName())).
					body("status", equalTo(expPet.getStatus())).
					body("photoUrls", equalTo(expPet.getPhotoUrls())).
					body("category.id", equalTo(expPet.getCategory().getId())).
					body("category.name", equalTo(expPet.getCategory().getName())).
					body("tags[0].id", equalTo(expPet.getTags().get(0).getId())).
					body("tags[0].name", equalTo(expPet.getTags().get(0).getName()));
		
	}
	
	/*
	 *  deletes the pet created in SetUp
	 */
	@AfterClass
	public void TearDown()
	{	
		// delete test pet 
		var response = given().
			when().
				delete(petIdEndpoint);
		
		// Log error if test pet was not cleaned up
		logForErrorResponse(response.getStatusCode(), response.getStatusLine(), "Failed to delete test pet");
	}
}
