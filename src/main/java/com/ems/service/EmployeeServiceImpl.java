package com.ems.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.EmployeeDao;
import com.ems.dto.EmployeeDto;
import com.ems.entiites.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public EmployeeDto getEmployeeByNo(int empNo) {
		EmployeeDto employeeDto = null;
		Employee employee = null;
		
		employeeDto = new EmployeeDto();
		
		employee = employeeDao.getEmployeeById(empNo);
		
		BeanUtils.copyProperties(employee, employeeDto);
	
		return employeeDto;
	}

}
