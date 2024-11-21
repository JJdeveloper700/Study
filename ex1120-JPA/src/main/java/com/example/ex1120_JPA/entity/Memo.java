package com.example.ex1120_JPA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity  
@Table(name="tbl_memo") 
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Memo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncreament를 알아서 넣어준다. 
	private Long mno; 
	@Column(length = 200, nullable = false)
	private String memoText;
	@Column(length = 100, nullable=  false)
	private String writer; 
	
	
}	 

