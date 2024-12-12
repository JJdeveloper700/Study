package com.example.sec03.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sec03.entity.Member;

@Mapper
public interface IMemberDao {
	
	public void regist(@Param("member")Member member);
	
	public Member findByUsername(String name);
}
