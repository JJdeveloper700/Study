package com.example.sec03.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sec03.entity.Board;

@Mapper
public interface IBoardDao {
	void regist(@Param("board")Board board);
}
