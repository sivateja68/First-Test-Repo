package com.arn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Employee_tab")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private Integer id;
	
	@Column(name="EmpName")
	private String empName;
	
	@Column(name="EmpDesig")
	private String empDesig;
	
	@Column(name="EmpSalary")
	private Double empSalary;
}
