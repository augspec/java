package com.aug.db.entities;

import java.io.Serializable;

public class Region implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String code;
	private boolean active;
	private int parentId;
	
	public Region() {
		
	}

	public Region(int id, String name, String code, boolean active, int parentId) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.active = active;
		this.parentId = parentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
}
