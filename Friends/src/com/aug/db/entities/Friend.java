package com.aug.db.entities;

import java.io.Serializable;

public class Friend implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String group;
	private String state;
	private String district;
	private String wards;
	private String inviteStatus;
	private String money;
	private String description;
	
	public Friend() {
		super();
	}

	public Friend(String name, String phone, String email, String address,
			String group, String state, String district, String wards,
			String inviteStatus, String money, String description) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.group = group;
		this.state = state;
		this.district = district;
		this.wards = wards;
		this.inviteStatus = inviteStatus;
		this.money = money;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWards() {
		return wards;
	}

	public void setWards(String wards) {
		this.wards = wards;
	}

	public String getInviteStatus() {
		return inviteStatus;
	}

	public void setInviteStatus(String inviteStatus) {
		this.inviteStatus = inviteStatus;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
