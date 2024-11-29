package com.example.ex03.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ex03.dto.MemberDto;

@Mapper
public interface IMemberDao {
	
	void regist(@Param("member")MemberDto memberDto); 
		
	 MemberDto LoginCheck(@Param("id")String id,@Param("pw")String pw);

	 int idCheck(@Param("id")String id);
	
}
