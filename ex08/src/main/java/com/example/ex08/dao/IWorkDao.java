package com.example.ex08.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ex08.dto.WorkDto;

@Mapper
public interface IWorkDao {
	
	void regist(@Param("work")WorkDto workDto);
	
	List<WorkDto>getList();
	
	WorkDto getWork(String id);
	
	void update(@Param("work")WorkDto workDto);
	
	
}
