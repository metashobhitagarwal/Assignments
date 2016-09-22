package com.employeemanagement;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employee")
public class Employee implements Serializable{

	private int empID;
	private String empName;
	private String empCompany;
	private String empAddress;
	private double empSalary;

	
	public Employee() {
	}

	public Employee(int empID, String empName, String empCompany,
			String empAddress, double empSalary) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empCompany = empCompany;
		this.empAddress = empAddress;
		this.empSalary = empSalary;
	}

	
	public int getEmpID() {
		return empID;
	}
	
	@XmlElement
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
	
	public String getEmpName() {
		return empName;
	}
	
	@XmlElement
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCompany() {
		return empCompany;
	}
	
	@XmlElement
	public void setEmpCompany(String empCompany) {
		this.empCompany = empCompany;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	@XmlElement
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	@XmlElement
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

}
