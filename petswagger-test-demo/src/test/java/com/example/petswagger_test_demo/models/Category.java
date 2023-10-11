package com.example.petswagger_test_demo.models;

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
	
	private void setId(int id)
	{
		this.id = id;
	}
	
	private void setName(String mame)
	{
		this.name = name;
	}
}
