package com.ems.dto;

public class EmployeeDto {
	
	protected int staffNo;
	protected String firstName;
	protected String lastName;
	protected String mobile;
	protected String email;
	protected String city;
	protected String state;
	
	public EmployeeDto() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeDto(int staffNo, String firstName, String lastName, String mobile, String email, String city,
			String state) {
		super();
		this.staffNo = staffNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
		this.state = state;
	}

	public int getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(int staffNo) {
		this.staffNo = staffNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
