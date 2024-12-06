package com.example.ex05.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ex05.dto.BoardDto;

@Mapper
public interface IBoardDao {
	
	void regist(@Param("board")BoardDto boardDto);
	
	List<BoardDto> getList();
	
	List<BoardDto> getList2();
	
	List<BoardDto> getList3(@Param("startNum")int startNum);
	
	BoardDto getBoard(int bno);
	
	void update(@Param("board")BoardDto boardDto);

	void delete(@Param("bno")int bno);
	
	
	
}
