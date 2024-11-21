package com.example.ex1120_JPA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity  
@Table(name="tbl_memo3") 
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {
	@Id
	@GeneratedValue
	
	private Long pw; 
	@Column(length = 200, nullable = false)
	private String id;
	@Column(length = 100, nullable=  false)
	private String name; 




}
