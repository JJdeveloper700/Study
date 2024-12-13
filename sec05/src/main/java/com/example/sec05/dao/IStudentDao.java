package com.example.sec05.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sec05.entity.Student;

@Mapper
public interface IStudentDao {
	
	void regist(@Param("Student")Student student);
	

}
