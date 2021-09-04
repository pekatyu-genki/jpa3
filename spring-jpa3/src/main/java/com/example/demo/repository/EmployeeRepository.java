package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

/**
 * 社員情報用インターフェイス
 * @author PCUser
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
