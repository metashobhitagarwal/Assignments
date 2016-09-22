package com.employeemanagement;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;


@Path("/resource")
public class EmpService {
	EmpDao empDao = new EmpDao();

	@POST
	@Path("/newemployee")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String addEmployee(@QueryParam("empName") String empName,
			@QueryParam("empCompany") String empCompany,
			@QueryParam("empAddress") String empAddress,
			@QueryParam("empSalary") float empSalary) throws SQLException {

		Employee employee = new Employee();
		employee.setEmpName(empName);
		employee.setEmpCompany(empCompany);
		employee.setEmpAddress(empAddress);
		employee.setEmpSalary(empSalary);
		
		int result = empDao.addEmployee(employee);
		if(result==1){
		return "New Employee successfully add !!!";	
		}
		
			return "Error ";
		
	}

	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeList() {
		return empDao.getEmployeeList();
	}

	@GET
	@Path("/employeelist/{empName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeListByName(@PathParam("empName") String empName) {
		
		return empDao.getEmployeeListByName(empName); //
	}

	@GET
	@Path("/employee/{empID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeByID(@PathParam("empID") int empID) {
		return empDao.getEmployeeByID(empID);
	}

	@DELETE
	@Path("/employeedelete/{empID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteEmployee(@PathParam("empID") int empID) throws SQLException {
		int result =  empDao.deleteEmployee(empID);
		if(result==1){
			return " Employee successfully Delete !!! ";	
			}
			
				return "Error ";
	}

}
