package com.example.ex1121_T.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@EntityListeners
@Getter

public class BaseEntity {
	@CreatedDate
	@Column(name="regdate", updatable= false)
	private LocalDateTime regDate; 
	
	@LastModifiedDate
	@Column(name="modifydate"); 
	

}
