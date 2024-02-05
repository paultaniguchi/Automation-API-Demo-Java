package com.example.petswagger_test_demo.models;

import java.util.List;

/*
 * POJO for the response JSON returned by the Swagger Petstore API 
 * 
 *  Author: Paul Taniguchi
 * 
 */

public class Pet {
	
	private int id;
	private Category category;
	private String name;
	private List<String> photoUrls;
	private List<Tags> tags;
	private String status;
	
	/*
	 * default constructor is placeholder
	 */
	public Pet()
	{
	}
	
	public Pet(int id, Category category, String name, List<String> photoUrls, List<Tags> tags, String status)
	{
		setId(id);
		setCategory(category);
		setName(name);
		setPhotoUrls(photoUrls);
		setTags(tags);
		setStatus(status);
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setCategory(Category category)
	{
		this.category = category;
	}
	
	public Category getCategory()
	{
		return this.category;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setPhotoUrls(List<String> photoUrls)
	{
		this.photoUrls = photoUrls;
	}
	
	public List<String> getPhotoUrls()
	{
		return this.photoUrls;
	}
	
	public void setTags(List<Tags> tags)
	{
		this.tags = tags;
	}
	
	public List<Tags> getTags()
	{
		return this.tags;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String getStatus()
	{
		return this.status;
	}
}
