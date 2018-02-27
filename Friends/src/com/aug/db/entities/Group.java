package com.aug.db.entities;

import java.io.Serializable;

public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	private int rowid;
	private String id;
	private String name;
	private String description;
	private String userId;
	
	public Group() {
		
	}

	public Group(String id, String name, String description, String userId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.userId = userId;
	}

	public int getRowid() {
		return rowid;
	}

	public void setRowid(int rowid) {
		this.rowid = rowid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
