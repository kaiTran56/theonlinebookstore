package com.team.model;

public class Category {
	private int catalog_id;
	private String name;
	private String parent_id;

	public Category(int catalog_id, String name, String parent_id) {
		super();
		this.catalog_id = catalog_id;
		this.name = name;
		this.parent_id = parent_id;
	}

	public Category(int catalog_id, String name) {
		super();
		this.catalog_id = catalog_id;
		this.name = name;
	}

	public int getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(int catalog_id) {
		this.catalog_id = catalog_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

}
