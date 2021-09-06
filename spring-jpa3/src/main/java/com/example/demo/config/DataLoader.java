package com.example.demo.config;

import org.springframework.stereotype.Component;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader {

	/** 定数 部門情報用インターフェイス格納 */
	private final DepartmentRepository repository;
	
	public void run(String... args) throws Exception {
		
		// 部門クラス呼び出し(インスタンス化)
		Department department = new Department();
		
		department.setName("営業");
		repository.save(department);
		
		department = new Department();
		department.setName("開発");
		repository.save(department);
	}
}
