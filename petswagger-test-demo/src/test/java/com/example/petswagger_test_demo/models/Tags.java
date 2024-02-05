package com.example.petswagger_test_demo.models;

/*
 *  POJO for the response JSON returned by the Swagger Petstore API
 *  Tags sub-object that is part of the response JSON
 *  
 *  Author: Paul Taniguchi
 * 
 */

public class Tags {
	
	private int id;
	private String name;
	
	public Tags()
	{}

	public Tags(int id, String name)
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
