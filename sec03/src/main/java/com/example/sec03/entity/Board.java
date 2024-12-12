package com.example.sec03.entity;

import lombok.Data;

@Data
public class Board {
	private int bno;
	private String title; 
	private String content; 
	private String writer; 
	private String regdate; 
	private String moddate;
}
