package com.example.ex00.dto;

import lombok.Data;

@Data
public class BoardDto {
	private int bno;
	private String title; 
	private String content; 
	private String writer; 
}
