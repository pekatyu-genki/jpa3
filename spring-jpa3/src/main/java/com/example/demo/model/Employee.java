package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * 社員情報クラスDto
 * @author PCUser
 *
 */
@Getter
@Setter
@Entity
public class Employee {

	/**
	 * 社員ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 名前
	 */
	@NotBlank
	@Size(max = 40)
	private String name;
	
	/**
	 * 所属部署へ紐づけ
	 */
	@ManyToOne
	private Department department;
}
