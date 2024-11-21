package com.example.mytest3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_b1")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Memo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long mno; 
	private String content; 
	private String title; 
	private String writer;
	
	
	
	
}
