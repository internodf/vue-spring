package com.backend.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Message {

	@Id
	private String id;
	private String description;
	private Date date;

	public Message() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
