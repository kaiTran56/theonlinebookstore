package com.team.model;

import java.io.Serializable;

public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Product product;
	private int amount;
	private double price;

	public Item(String id, Product product, int amount, double price) {
		super();
		this.id = id;
		this.product = product;
		this.amount = amount;
		this.price = price;
	}

	public Item(Product product, int amount, double price) {
		super();
		this.product = product;
		this.amount = amount;
		this.price = price;
	}

	public Item() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return id+" : "+product.getName() + " : " + product.getDescription()+" : "+ amount;
	}

}
