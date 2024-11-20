package com.example.mytest2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mytest2.entity.Board;


public interface Boardrepository extends JpaRepository<Board,Long>{

}
