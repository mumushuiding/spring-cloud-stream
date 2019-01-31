package com.lt.cloud.pojo;

import java.io.Serializable;

public class Employee implements Serializable {
	private String employeeFName;
	private long emp_id;
	private String address;
	private String mobileNumber;
	private String employeeLName;
	public Employee() {
	// TODO Auto-generated constructor stub
	employeeFName = "no name";
	employeeLName = "no l name";
	emp_id = 0;
	address = "Maharashtra";
	mobileNumber = "1234";
	}
	public Employee(String employeeFName, long emp_id,
		String address, String mobileNumber, String employeeLName)
	{
			this.employeeFName = employeeFName;
			this.emp_id = emp_id;
			this.address = address;
			this.mobileNumber = mobileNumber;
			this.employeeLName = employeeLName;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeFName=" + employeeFName + ", emp_id=" + emp_id + ", address=" + address
				+ ", mobileNumber=" + mobileNumber + ", employeeLName=" + employeeLName + "]";
	}
	public String getEmployeeFName() {
		return employeeFName;
	}
	public void setEmployeeFName(String employeeFName) {
		this.employeeFName = employeeFName;
	}
	public long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmployeeLName() {
		return employeeLName;
	}
	public void setEmployeeLName(String employeeLName) {
		this.employeeLName = employeeLName;
	}
	
}
