package com.team.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
	private String id;
	private List<Item> items;
	private double sumPrice;
	private LocalDateTime created;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
	public String toString() {

		return id+": "+items.toString() + ": " + sumPrice;
	}

}
