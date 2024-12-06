package com.example.ex05.dto;

import lombok.Data;

@Data
public class BoardDto {
	private int bno; 
	private String title; 
	private String content; 
	private String writer; 
	private String regdate; 
	private String moddate; 
	private int reply_cnt;
}
