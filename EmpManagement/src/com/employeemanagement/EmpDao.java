package com.employeemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmpDao {

	Connection con = new DBConnection().getConnection();

	public int addEmployee(Employee employee) throws SQLException {

		String addIntoEmployee = "INSERT INTO `empdb`.`employee` (`empName`, `empCompany`, `empAddress`, `empSalary`)"
				+ "VALUES(?,?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(addIntoEmployee);
		pstmt.setString(1, employee.getEmpName());
		pstmt.setString(2, employee.getEmpCompany());
		pstmt.setString(3, employee.getEmpAddress());
		pstmt.setDouble(4, employee.getEmpSalary());

		int result = pstmt.executeUpdate();
		return result;

	}

	public int deleteEmployee(int empID) throws SQLException {
		String deleteFromEmployee = "delete from employee where empID=?";
		PreparedStatement pstmt = con.prepareStatement(deleteFromEmployee);
		pstmt.setInt(1, empID);

		int result = pstmt.executeUpdate();
		return result;
	}

	public List<Employee> getEmployeeList() {
		ResultSet rs = null;
		String getEmployee = "select * from employee";
		List<Employee> employeeList = new LinkedList<Employee>();
		try {
			PreparedStatement pstmt = con.prepareStatement(getEmployee);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee temp = new Employee();
				temp.setEmpID(rs.getInt("empID"));
				temp.setEmpName(rs.getString("empName"));
				temp.setEmpCompany(rs.getString("empCompany"));
				temp.setEmpAddress(rs.getString("empAddress"));
				temp.setEmpSalary(rs.getDouble("empSalary"));
				employeeList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employeeList;
	}

	public Employee getEmployeeByID(int empID) {
		ResultSet rs = null;
		String getEmployee = "select * from employee where empID=?";
		Employee employee = new Employee();
		try {
			PreparedStatement pstmt = con.prepareStatement(getEmployee);
			pstmt.setInt(1, empID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				employee.setEmpID(rs.getInt("empID"));
				employee.setEmpName(rs.getString("empName"));
				employee.setEmpCompany(rs.getString("empCompany"));
				employee.setEmpAddress(rs.getString("empAddress"));
				employee.setEmpSalary(rs.getDouble("empSalary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	public List<Employee> getEmployeeListByName(String empName) {
		ResultSet rs = null;
		String getEmployee = "select * from employee where empName =?";
		List<Employee> employeeList = new LinkedList<Employee>();
		try {
			PreparedStatement pstmt = con.prepareStatement(getEmployee);
			pstmt.setString(1, empName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee temp = new Employee();
				temp.setEmpID(rs.getInt("empID"));
				temp.setEmpName(rs.getString("empName"));
				temp.setEmpCompany(rs.getString("empCompany"));
				temp.setEmpAddress(rs.getString("empAddress"));
				temp.setEmpSalary(rs.getDouble("empSalary"));
				employeeList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employeeList;
	}

}
