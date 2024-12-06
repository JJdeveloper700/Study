package com.example.ex05.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ex05.dto.ReplyDto;

@Mapper
public interface IReplyDao {
	
	void regReply(@Param("reply")ReplyDto reply);
	
	List<ReplyDto> getList(@Param("bno")int bno);
	
	
}
