package com.cts.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.emp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
