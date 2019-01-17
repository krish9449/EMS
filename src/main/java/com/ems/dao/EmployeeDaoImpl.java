package com.ems.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ems.entiites.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	//@Autowired
	//private SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Employee getEmployeeById(int empId) {
		Employee employee = null;
		//employee = sessionFactory.openSession().get(Employee.class, empId);
		employee = hibernateTemplate.get(Employee.class, empId);
		
		
		return employee;
	}
}
