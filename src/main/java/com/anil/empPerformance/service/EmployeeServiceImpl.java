package com.anil.empPerformance.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anil.empPerformance.dao.EmployeeDAO;
import com.anil.empPerformance.data.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired 
	EmployeeDAO employeeDAO;
	
	
	@Override
	public Employee create(Employee employee) {
		// TODO Auto-generated method stub
		if(employee == null)
			return null;
		UUID newId = UUID.randomUUID();
		employee.setId(newId.toString());
		return employeeDAO.create(employee);
	}

	@Override
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		if(employee == null)
		return null;
		
		return employeeDAO.update(employee);
	}

	@Override
	public List<Employee> list() {
		// TODO Auto-generated method stub
		return employeeDAO.list();
	}

	@Override
	public Employee get(String id) {
		// TODO Auto-generated method stub
		if(id == null)
		return null;
		
		return employeeDAO.get(id);
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		if(id == null)
			return null;
		Employee employee = get(id);
			return employeeDAO.delete(employee);
	}

	
	
}
