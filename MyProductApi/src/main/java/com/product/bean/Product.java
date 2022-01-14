package com.product.bean;

public class Product {
	private long id;
    private String code;
    private String name;
    private String description;
    private double price;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product(long id, String code, String name, String description, double price) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Product() {
		
	}
    
    
	
}
