package com.example.Mytest4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="kbl_board10")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mno;
	private String title; 
	private String content; 
	private String writer; 
	
	
	
}
