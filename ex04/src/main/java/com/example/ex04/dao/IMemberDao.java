package com.example.ex04.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ex04.dto.MemberDTO;

@Mapper
public interface IMemberDao {
	public MemberDTO getMember(@Param("member")MemberDTO member);
	public List<MemberDTO> getList(); 


}
