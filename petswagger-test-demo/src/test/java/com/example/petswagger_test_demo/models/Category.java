package com.example.petswagger_test_demo.models;

/*
 *  POJO for the response JSON returned by the Swagger Petstore API
 *  Category sub-object that is part of the response JSON
 *  
 *  Author: Paul Taniguchi
 * 
 */

public class Category {

	private int id;
	private String name;
	
	public Category()
	{
	}
	
	public Category(int id, String name)
	{
		setId(id);
		setName(name);
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
}
