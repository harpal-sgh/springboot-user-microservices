package com.cde.rest.services.restservices.versioning;

public class PersonV1 {

	private String name;

	public PersonV1() {		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonV1(String name) {
		super();
		this.name = name;
	}
}
