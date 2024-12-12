package com.example.sec02.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sec02.entity.Member;

@Mapper
public interface IMemberDao {
	
	public void insert(@Param("member")Member member);
	
	public Member findByUsername(String username);
	//JPA로 쓸떄는 이렇게 쓰지만 JpA가 아니면 getMember로 써도된다. 

}
