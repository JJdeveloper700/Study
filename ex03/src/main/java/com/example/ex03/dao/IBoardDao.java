package com.example.ex03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ex03.dto.BoardDto;
import com.example.ex03.dto.MemberDto;

@Mapper

public interface IBoardDao {
	
	void regist(@Param("board")BoardDto boardDto); 
	
	List<BoardDto> getList();
	
	
}
