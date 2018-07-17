package com.anil.empPerformance.dao;

import java.util.List;

import com.anil.empPerformance.data.Employee;

public interface EmployeeDAO {

	public Employee create(Employee employee);
	
	public Employee update(Employee employee);
	
	public List<Employee> list();
	
	public Employee get(String id);

	public Boolean delete(Employee employee);
	
	
}
