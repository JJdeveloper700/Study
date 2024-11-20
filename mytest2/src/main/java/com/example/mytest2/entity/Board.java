package com.example.mytest2.entity;

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
@Table(name="tbl_board12")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long bno; 
	private String title; 
	private String content; 
	private String writer; 
}
