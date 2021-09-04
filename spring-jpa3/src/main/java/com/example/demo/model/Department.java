package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * 部署クラスDto
 * @author PCUser
 *
 */
@Getter
@Setter
@Entity
public class Department {

	/**
	 * 部署ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 部署名
	 */
	@NotBlank
	@Size(max = 40)
	private String name;
	
	/**
	 * 状態：リスト管理
	 */
	@OneToMany
	private List<Employee> employees;
}
