package com.example.sec05.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sec05.entity.Problem;

@Mapper	
public interface IProblemDao {
	
	List<Problem>getList();
}
