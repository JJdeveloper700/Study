package com.example.ex08.dto;

import lombok.Data;

@Data
public class BoardDto {
	private int bno; 
	private String writer; 
	private String title; 
	private String content; 
	private String regdate; 
	private String moddate; 
}
