package com.example.sec05.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sec05.entity.Member;



@Mapper
public interface IMemberDao {
	
	void regist(@Param("member")Member member);
	
	
	
	
}
