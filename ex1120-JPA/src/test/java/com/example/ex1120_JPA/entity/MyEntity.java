package com.example.ex1120_JPA.entity;

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
@Table(name="tbl_memo5") // 
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyEntity {
	@Id
	@GeneratedValue
	private Long bno; 
	private String title ;
	private String content; 
	private String writer; 
}
