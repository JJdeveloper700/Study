package com.example.mytest2;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mytest2.entity.Board;
import com.example.mytest2.repository.Boardrepository;

@SpringBootTest // 스프링이 관리하는 것들을 사용할수 있다. 
public class BoardRepositoryTest {
	@Autowired
	Boardrepository boardRepository;
	
	@Test
	void testInsert() {
		Board board = new Board(1L,"제목1","내용1","관리자"); 
		boardRepository.save(board); //엔티티에 있는 값을 넣어준다. 
	}
}
