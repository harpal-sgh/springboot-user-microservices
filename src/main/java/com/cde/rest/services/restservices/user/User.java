package com.cde.rest.services.restservices.user;

import java.util.Date;

public class User {
	private Integer id;
	
	private String name;
	
	private Date birthDate;
	
	protected User() {
		
	}
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthData() {
		return birthDate;
	}

	public void setBirthData(Date birthData) {
		this.birthDate = birthData;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthData=" + birthDate + "]";
	}
	

}
