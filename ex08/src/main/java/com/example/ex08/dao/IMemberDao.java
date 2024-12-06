package com.example.ex08.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ex08.dto.MemberDto;

@Mapper
public interface IMemberDao {
	
	void regist(@Param("member")MemberDto memberDto);
	
	
	int idCheck(@Param("id")String id); 
	
	
	MemberDto LoginCheck(@Param("id")String id,@Param("pw")String pw);
	
	





}

