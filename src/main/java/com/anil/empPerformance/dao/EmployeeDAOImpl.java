package com.anil.empPerformance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anil.empPerformance.data.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public Employee create(Employee employee) {
		// TODO Auto-generated method stub
		if(employee == null)
		return null;
		
	    Session session = sessionFactory.getCurrentSession();
	    try{
	    	session.save(employee);	    
		    return employee;
	    }catch(Exception e){
	    	throw new RuntimeException();
	    }
	}

	@Override
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		if(employee == null)
			return null;
			
		    Session session = sessionFactory.getCurrentSession();
		    try{
		    	session.update(employee);	    
			    return employee;
		    }catch(Exception e){
		    	throw new RuntimeException();
		    }
	}

	@Override
	public List<Employee> list() {
		// TODO Auto-generated method stub
		try{
			Session session = sessionFactory.getCurrentSession();
			String queryString = "From Employee ";

            Query query = session.createQuery(queryString);
			
			return query.list();
			
		}catch(Exception e){
			throw new RuntimeException();
		}
	}

	@Override
	public Employee get(String id) {
		// TODO Auto-generated method stub
		if(id == null)
			return null;
			
		    Session session = sessionFactory.getCurrentSession();
		    try{
		    	Employee employee = session.get(Employee.class, id);	    
			    return employee;
		    }catch(Exception e){
		    	throw new RuntimeException();
		    }
	}

	@Override
	public Boolean delete(Employee employee) {
		// TODO Auto-generated method stub
		if(employee == null)
			return null;
			
		    Session session = sessionFactory.getCurrentSession();
		    try{
		      session.delete(employee);
			    return true;
		    }catch(Exception e){
		    	throw new RuntimeException();
		    }
	}


}
