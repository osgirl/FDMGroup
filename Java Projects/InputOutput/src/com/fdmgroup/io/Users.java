package com.fdmgroup.io;

public class Users {
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	
	public Users(String firstName, String lastName, String address, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
	}

	public String toString(){
		return "User " + firstName + " " + lastName + " lives at " + address + ". (E-mail: " + email + ")";
	}
	
	protected String getFirstName() {
		return firstName;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected String getLastName() {
		return lastName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected String getAddress() {
		return address;
	}

	protected void setAddress(String address) {
		this.address = address;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}
}
