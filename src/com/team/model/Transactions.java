package com.team.model;

import java.time.LocalDateTime;

public class Transactions {
	private int transaction_id;
	private User user;
	private String message;
	private double payment;
	private String status;
	private LocalDateTime created;
	private Ordered ordered;

	public Transactions(int transaction_id, User user, String message, double payment, String status, Ordered ordered,
			LocalDateTime created) {
		super();
		this.transaction_id = transaction_id;
		this.user = user;
		this.message = message;
		this.payment = payment;
		this.status = status;
		this.created = created;
		this.ordered = ordered;
	}

	public Transactions(int transaction_id, User user, String message, double payment, String status,
			LocalDateTime created) {
		super();
		this.transaction_id = transaction_id;
		this.user = user;
		this.message = message;
		this.payment = payment;
		this.status = status;
		this.created = created;
	}

	public Transactions(User user, String message, double payment, String status, LocalDateTime created) {
		super();
		this.user = user;
		this.message = message;
		this.payment = payment;
		this.status = status;
		this.created = created;
	}

	public Transactions(int transaction_id) {
		super();
		this.transaction_id = transaction_id;
	}

	public Transactions(int transaction_id, String status) {
		super();
		this.transaction_id = transaction_id;
		this.status = status;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public Ordered getOrdered() {
		return ordered;
	}

	public void setOrdered(Ordered ordered) {
		this.ordered = ordered;
	}

	public String toString() {
		return message;
	}

}
