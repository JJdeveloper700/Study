package com.example.ex1121_T.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	private int bno; 
	private String title; 
	private String content;
	private String writer; 
	private LocalDateTime modifydate;
	private LocalDateTime regDate;
}
