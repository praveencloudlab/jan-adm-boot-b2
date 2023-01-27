package com.cts.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.emp.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
