package com.example.ex1121_T.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex1121_T.entity.Board;

public interface Boardrepository extends JpaRepository<Board, Integer> {

}
