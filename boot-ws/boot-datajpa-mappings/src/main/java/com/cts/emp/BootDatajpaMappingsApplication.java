package com.cts.emp;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cts.emp.entity.Department;
import com.cts.emp.entity.Employee;
import com.cts.emp.repository.DepartmentRepository;
import com.cts.emp.repository.EmployeeRepository;
import com.cts.emp.service.EmployeeServiceImpl;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

@SpringBootApplication
public class BootDatajpaMappingsApplication {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ConfigurableApplicationContext ac = SpringApplication.run(BootDatajpaMappingsApplication.class, args);
		
		EmployeeRepository empRepo = ac.getBean(EmployeeRepository.class);
		DepartmentRepository deptRepo = ac.getBean(DepartmentRepository.class);
		EmployeeServiceImpl es = ac.getBean(EmployeeServiceImpl.class);
		
		//Department d1=new Department(11, "IT", "Chennai");
		//Employee e1=new Employee(100, "Praveen", 34934, d1);
		
		//empRepo.save(e1);
		
		//Employee emp = es.loadEmployee();
		//System.out.println(emp);
		/*
		Department dept = deptRepo.findById(emp.getDept().getDeptId()).orElse(null);
		if(dept!=null) {
			emp.setDept(dept);
			empRepo.save(emp); // new employee with existing dept
		}else {
			empRepo.save(emp); // new employee with new dept
		}
		*/
		
		es.loadEmployees().forEach(emp->{
			Department dept = deptRepo.findById(emp.getDept().getDeptId()).orElse(null);
			if(dept!=null) {
				emp.setDept(dept);
				empRepo.save(emp); // new employee with existing dept
			}else {
				empRepo.save(emp); // new employee with new dept
			}
		});
		
		
		
		
		
		
	}

}
