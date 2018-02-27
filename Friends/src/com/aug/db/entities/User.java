package com.aug.db.entities;

import java.io.Serializable;
import java.lang.reflect.Field;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int rowid;
	private String id;
	private String username;
	private String password;
	private String nicename;
	private String email;
	private String address;
	private String permission;
	
	public User() {
		
	}

	public User(String id, String username, String password, String nicename,
			String email, String address, String permission) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nicename = nicename;
		this.email = email;
		this.address = address;
		this.permission = permission;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNicename() {
		return nicename;
	}

	public void setNicename(String nicename) {
		this.nicename = nicename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		Field[] fields = this.getClass().getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		
		int index = 0;
		for (Field field : fields) {
			if (field.getName().equals("serialVersionUID"))
				continue;
			
			field.setAccessible(true);
			try {
				sb.append("\n\t\"" + field.getName() + "\": \"" + field.get(this) + "\"");
				if (index < fields.length - 1)
					sb.append(",");
				index++;
			} catch (Exception e) {
				e.printStackTrace();
			}
			field.setAccessible(false);
		}
		sb.append("\n}");
		
		return sb.toString();
	}
	
}
