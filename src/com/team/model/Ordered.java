package com.team.model;

public class Ordered {
	private int ordered_id;
	private int product_id;
	private int transaction_id;
	private int amount;
	private String name;
	private double price;
	private String username;
	private int total_purchase;
	private int total_product;
	private String urlTemp;
	private String image_link;

	public Ordered(int ordered_id, int product_id, int transaction_id, int amount) {
		super();
		this.ordered_id = ordered_id;
		this.product_id = product_id;
		this.transaction_id = transaction_id;
		this.amount = amount;
	}

	public Ordered(int ordered_id, int product_id, int amount, String name, double price) {
		super();
		this.ordered_id = ordered_id;
		this.product_id = product_id;
		this.amount = amount;
		this.name = name;
		this.price = price;
	}

	public Ordered(int amount, String name) {
		super();
		this.amount = amount;
		this.name = name;
	}

	public Ordered(String username, String name, int amount, double price) {
		super();
		this.username = username;
		this.amount = amount;
		this.name = name;
		this.price = price;
	}

	public Ordered(int product_id, int transaction_id, int amount) {
		super();
		this.product_id = product_id;
		this.transaction_id = transaction_id;
		this.amount = amount;
	}

	/*
	 * Object for the best seller include: product_id + name_product +
	 * total_purchase + total_product
	 */

	public Ordered(int product_id, String name, int total_purchase, int total_product, String image_link) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.total_purchase = total_purchase;
		this.total_product = total_product;
		this.image_link = image_link;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public int getTotal_purchase() {
		return total_purchase;
	}

	public void setTotal_purchase(int total_purchase) {
		this.total_purchase = total_purchase;
	}

	public int getTotal_product() {
		return total_product;
	}

	public void setTotal_product(int total_product) {
		this.total_product = total_product;
	}

	public Ordered(int ordered_id) {
		super();
		this.ordered_id = ordered_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getOrdered_id() {
		return ordered_id;
	}

	public void setOrdered_id(int ordered_id) {
		this.ordered_id = ordered_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setUrlTemp(String urlTemp) {
		this.urlTemp = urlTemp;
	}

	public String getUrlTemp() {
		String url = "C:\\Users\\ASUS\\eclipse-workspacejee\\theonlinebook\\WebContent\\";
		int len = this.getImage_link().length();
		System.out.println("Address: " + this.getImage_link() + " The length: " + len);
		urlTemp = this.getImage_link().substring(url.length(), len).replace("\\", "//");
		return urlTemp;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " " + name + " " + amount + " " + image_link;
	}

}
