package com.example.mytest3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mytest3.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Integer> {

}
