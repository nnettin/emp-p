package com.anil.empPerformance.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anil.empPerformance.data.Employee;
import com.anil.empPerformance.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/emp")
public class EmpController {
	@Autowired 
	EmployeeService empService;

	@RequestMapping(value = "/create", method=RequestMethod.POST)
	public Object createEmp(@RequestBody Object empData){
		ObjectMapper om = new ObjectMapper();
		try{
			
			String jsonData = om.writeValueAsString(empData);
			
			Employee employee = om.readValue(jsonData, Employee.class);
			
			Employee returnEmpObject = empService.create(employee);
			if(returnEmpObject == null){
				return null;
			}else{
				return returnEmpObject;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		 
		return empData;
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public Object updateEmp(@RequestBody Object empData){
		ObjectMapper om = new ObjectMapper();
		try{
			
			String jsonData = om.writeValueAsString(empData);
			
			Employee employee = om.readValue(jsonData, Employee.class);
			
			Employee returnEmpObject = empService.update(employee);
			if(returnEmpObject == null){
				return null;
			}else{
				return returnEmpObject;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		 
		return empData;
	}
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public List<Employee> list(){
		
		List<Employee> empList = empService.list();
		if(empList == null){
			return null;
		}else{
			return empList;
		}
	}
	
	@RequestMapping(value = "/get/{id}", method=RequestMethod.GET)
	public Object get(@PathVariable String id){
		
		Employee employee = empService.get(id);
		if(employee == null){
			return null;
		}else{
			return employee;
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
	public Object delete(@PathVariable String id){
		
		Boolean flag = empService.delete(id);
		if(flag == null){
			return null;
		}else{
			return flag;
		}
	}
}
