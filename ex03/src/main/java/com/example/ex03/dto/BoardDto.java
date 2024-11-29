package com.example.ex03.dto;

import lombok.Data;

@Data
public class BoardDto {
	private int bno; 
	private String title; 
	private String content; 
	private String writer; 
	private String regdate; 
	private String moddate; 
}
