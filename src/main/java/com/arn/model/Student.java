package com.arn.model;


import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="Stu")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="stdId")
	private Integer id;

	@Column(name="Name")
	private String name;

	@Column(name="email")
	private String email;

	@Column(name="pwd")
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name="user_rolestab",
			joinColumns = @JoinColumn(name="id")
			)
	private Set<String> roles;
	

}
