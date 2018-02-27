package com.aug.db.entities;

import java.io.Serializable;

public class Region implements Serializable {

	private static final long serialVersionUID = 1L;
	private int rowid;
	private String id;
	private String name;
	private String code;
	private String active;
	private String parentId;
	
	public Region() {
		
	}

	public Region(String id, String name, String code, String active, String parentId) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.active = active;
		this.parentId = parentId;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
