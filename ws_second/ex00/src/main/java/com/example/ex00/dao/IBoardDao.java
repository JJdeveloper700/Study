package com.example.ex00.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ex00.dto.BoardDto;

@Mapper
public interface IBoardDao {
	//등록 - 게시글 정보(제목,내용,작성자)를 DB board 테이블에 저장하기 
	void regist(@Param("board")BoardDto board);
	//전체 조회 - DB Board 테이블에 저장된 모든 게시글 정보를 클라이언트(view)에 전달하기 
	List<BoardDto> getList(); 
	//개별 조회 - DB board 테이블에 저장된 특정 게시글 정보를 클라이언트(view)에 전달하기  
	BoardDto getBoard(int bno);
	// 수정 - DB board 테이블에 저장된 특정 게시글 정보를 수정하기
	void updateBoard(@Param("board")BoardDto board);
	//삭제 - DB board 테이블에 저장된 특정 게시글 정보를 삭제하기
	void deleteBoard(@Param("bno")int bno);
}
