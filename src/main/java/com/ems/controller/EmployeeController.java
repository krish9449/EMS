package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ems.dto.EmployeeDto;
import com.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/emp-details.htm")
	public String getEmployeeDetails(Model model) {
		EmployeeDto employeeDto = null;
		employeeDto = employeeService.getEmployeeByNo(1);
		
		model.addAttribute("emp", employeeDto);
		
		return "emp-details";
	}
}
