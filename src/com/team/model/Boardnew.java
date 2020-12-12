package com.team.model;

import java.time.LocalDateTime;

public class Boardnew {
	private int boardnew_id;
	private String title;
	private String content;
	private String image_link;
	private String author;
	private LocalDateTime created;
	private String urlTemp;

	public Boardnew(int boardnew_id, String title, String image_link, String author, LocalDateTime created) {
		super();
		this.boardnew_id = boardnew_id;
		this.title = title;

		this.image_link = image_link;
		this.author = author;
		this.created = created;
	}

	/*
	 * @show the detail of boardnews
	 * 
	 * 
	 */

	public Boardnew(int boardnew_id, String title, String content, String image_link, String author,
			LocalDateTime created) {
		super();
		this.boardnew_id = boardnew_id;
		this.title = title;
		this.content = content;
		this.image_link = image_link;
		this.author = author;
		this.created = created;
	}

	public Boardnew(String title, String content, String author, LocalDateTime created) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.created = created;
	}

	public Boardnew(String title, String content, String image_link, String author, LocalDateTime created) {
		super();
		this.title = title;
		this.content = content;
		this.image_link = image_link;
		this.author = author;
		this.created = created;
	}

	public void setUrlTemp(String urlTemp) {
		this.urlTemp = urlTemp;
	}

	public Boardnew(String image_link) {
		super();
		this.image_link = image_link;
	}

	public int getBoardnew_id() {
		return boardnew_id;
	}

	public void setBoardnew_id(int boardnew_id) {
		this.boardnew_id = boardnew_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage_link() {

		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
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
		return "name: " + author + " URlTemp: " + getUrlTemp() + " Name: " + title + " Content: " + content;
	}
}
