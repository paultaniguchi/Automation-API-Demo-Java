package com.example.petswagger_test_demo.models;

import java.util.List;

public class Pet {
	
	private int id;
	private Category category;
	private String name;
	private List<String> photosUrl;
	private List<Tags> tags;
	private String status;
	
	/*
	 * default constructor is placeholder
	 */
	public Pet()
	{
	}
	
	public Pet(int id, Category category, String name, List<String> photosUrls, List<Tags> tags, String status)
	{
		setId(id);
		setCategory(category);
		setName(name);
		setPhotosUrl(photosUrls);
		setTags(tags);
		setStatus(status);
	}
	
	private void setId(int id) 
	{
		this.id = id;
	}
	
	private void setCategory(Category category)
	{
		this.category = category;
	}
	
	private void setName(String name)
	{
		this.name = name;
	}
	
	private void setPhotosUrl(List<String> photosUrl)
	{
		this.photosUrl = photosUrl;
	}
	
	private void setTags(List<Tags> tags)
	{
		this.tags = tags;
	}
	
	private void setStatus(String status)
	{
		this.status = status;
	}
}
