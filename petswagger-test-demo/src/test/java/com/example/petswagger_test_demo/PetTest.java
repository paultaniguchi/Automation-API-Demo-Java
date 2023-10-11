package com.example.petswagger_test_demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.petswagger_test_demo.models.Pet;
import com.example.petswagger_test_demo.models.Category;
import com.example.petswagger_test_demo.models.Tags;

import java.util.List;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class PetTest 
{
	
	@BeforeClass
	/*
	 *  put in the test pet
	 */
	public void SetUp()
	{
	}
	
	@Test
	public void someTest()
	{
		String endpoint = "https://petstore.swagger.io/v2/pet/435";
		
		// set expected results
		Category expCategory = new Category(506,"Fish");
		Tags expTags = new Tags(351,"Taco");
		List<Tags> expTagList = new ArrayList<Tags>();
		expTagList.add(expTags);
		List<String> expPhotoUrl = new ArrayList<String>();
		
		//Pet actualPet = given().when().get(endpoint).as(Pet.class);
		var response = given().when().get(endpoint).then();
		
		response.log().body();
		
	}
	
	@AfterClass
	public void TearDown()
	{	
	}
}
