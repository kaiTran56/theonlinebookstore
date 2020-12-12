package com.team.model;

import java.time.LocalDateTime;

public class Review {
	private String review_id;
	private String product_id;
	private String name;
	private String content;
	private LocalDateTime created;

	public Review(String review_id, String product_id, String name, String content, LocalDateTime created) {
		super();
		this.review_id = review_id;
		this.product_id = product_id;
		this.name = name;
		this.content = content;
		this.created = created;
	}

	public String getReview_id() {
		return review_id;
	}

	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

}
