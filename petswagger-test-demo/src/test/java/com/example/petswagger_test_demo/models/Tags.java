package com.example.petswagger_test_demo.models;

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
	
	private void setId(int id)
	{
		this.id = id;
	}
	
	private void setName(String name)
	{
		this.name = name;
	}
}
