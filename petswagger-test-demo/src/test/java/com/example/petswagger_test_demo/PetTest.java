package com.example.petswagger_test_demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

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
	// set up test data 
	private Category expCategory = new Category(1001,"Fish");
	private Tags expTags = new Tags(1002,"Taco");
	private List<Tags> expTagList = Arrays.asList(expTags);
	private List<String> expPhotoUrl = Arrays.asList("https://www.example.com/photo1.jpg",
			"https://www.example.com/photo2.jpg");
	private Pet expPet = new Pet(1000, expCategory, "Furd", expPhotoUrl, expTagList, "pending");
	
	/*
	 *  put in the test pet
	 */
	@BeforeClass
	public void SetUp()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
		
		// create the pet in swagger.io that is used in the GET test
		given().
			contentType("application/json").
			body(expPet).	
				when().
					post();		
	}
	


	/*
	 * check that the GET request returns correct pet by
	 * checking each item in the response json
	 */
	@Test()
	public void testGetPet()
	{
		
		given().
			when().
				get("/1000").
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
		given().
			when().
				delete();
	}
}
