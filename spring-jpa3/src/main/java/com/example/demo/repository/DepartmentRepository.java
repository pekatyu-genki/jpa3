package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Department;

/**
 * 部署情報用インターフェイス
 * @author PCUser
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
