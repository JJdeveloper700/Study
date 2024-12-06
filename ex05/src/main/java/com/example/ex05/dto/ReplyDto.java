package com.example.ex05.dto;

import lombok.Data;

@Data
public class ReplyDto {
	private int rno; 
	private String comments; 
	private String writer; 
	private String regdate; 
	private int bno;
}
